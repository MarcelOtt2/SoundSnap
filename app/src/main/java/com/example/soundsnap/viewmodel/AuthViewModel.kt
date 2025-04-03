package com.example.a04_11_abschluss.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.model.TrackResponse
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.jvm.java

class AuthViewModel : ViewModel() {
    private val auth = Firebase.auth
    private val firebaseDB = Firebase.firestore

    private lateinit var currentUserId: String
    private var favoriteListDocRef: DocumentReference? = null

    init {
        Log.d("FIRE", "INIT BEFORE: ${auth.currentUser}")
        if (auth.currentUser != null) {
            Log.d("FIRE", "!= NULL IN: ${auth.currentUser!!.uid}")
            currentUserId = auth.currentUser!!.uid
            setCurrentFavoriteList(currentUserId)
        }
    }
    // Auth
    private val _currentUser = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val currentUser = _currentUser.asStateFlow()

    fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                _currentUser.value = auth.currentUser
                currentUserId = auth.currentUser!!.uid
                setCurrentFavoriteList(currentUserId)
            } else {
                Log.e("AUTH", it.exception?.localizedMessage.toString())
            }
        }
    }

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                _currentUser.value = auth.currentUser
                currentUserId = auth.currentUser!!.uid
                setCurrentFavoriteList(currentUserId)
            } else {
                Log.e("AUTH", it.exception?.localizedMessage.toString())
            }
        }
    }

    fun logout() {
        auth.signOut()
        _currentUser.value = null
        _favoriteTrackList.value = listOf()
        favoriteListDocRef = null
    }
    // Firebase Firestore
    private fun setCurrentFavoriteList(userId: String) {
        favoriteListDocRef = firebaseDB
            .collection("favorites")
            .document("userId: $userId")

        favoriteListDocRef?.get()?.addOnCompleteListener {
            if (it.isSuccessful) {
                val result = it.result
                if (result != null) {
                    if (!result.exists()) {
                        favoriteListDocRef?.set(
                            TrackResponse()
                        )
                    }
                }
            }
        }
        favoriteListDocRef?.addSnapshotListener { value, error ->
            Log.d("FIRE", "addSnapshotListener: value: $value")
            Log.d("FIRE", "addSnapshotListener: error: $error")
            if (error == null && value != null) {
                val response = value.toObject(TrackResponse::class.java)
                Log.d("FIRE", "addSnapshotListener: response: $response")
                Log.d("FIRE", "addSnapshotListener: response.results: ${response?.tracks}")
                _favoriteTrackList.value = (response?.tracks ?: listOf())
            }
        }
    }

    private val _favoriteTrackList = MutableStateFlow<List<Track>>(listOf())
    val favoriteTrackList = _favoriteTrackList.asStateFlow()

    fun addTrackToFavoriteList(track: Track?) {
        Log.d("AuthViewModel", "Adding track to favorite list: $track")
        favoriteListDocRef?.update("tracks", FieldValue.arrayUnion(track))
        Log.d("AuthViewModel", "Adding track to favorite list userID: ${currentUser.value}")
    }

    fun removeTrackFromFavoriteList(track: Track?) {
        Log.d("AuthViewModel", "Removing track from favorite list: $track")
        favoriteListDocRef?.update("tracks", FieldValue.arrayRemove(track))
    }

}



