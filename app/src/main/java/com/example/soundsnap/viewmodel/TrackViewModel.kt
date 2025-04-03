package com.example.a04_11_abschluss.viewmodel

import android.app.Application
import android.media.MediaPlayer
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.model.TrackResponse
import com.example.a04_11_abschluss.remote.TrackApi
import com.example.a04_11_abschluss.repository.TrackRepositoryImpl
import com.example.a04_11_abschluss.repository.TrackRepositoryInterface
import com.example.soundsnap.data.TrackDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TrackViewModel(application: Application) : AndroidViewModel(application) {

    private val trackRepository: TrackRepositoryInterface

    private val _tracks = MutableStateFlow<List<Track>>(emptyList())
    val tracks: StateFlow<List<Track>> = _tracks

    private val _selectedTrack = MutableStateFlow<Track?>(null)
    val selectedTrack: StateFlow<Track?> = _selectedTrack

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying

    private var mediaPlayer: MediaPlayer? = null

    private var currentTrackIndex = 0

    init {
        val api = TrackApi.apiService
        val trackDatabase = TrackDatabase.getDatabase(application)
        val trackDao = trackDatabase.dao
        trackRepository = TrackRepositoryImpl(api, trackDao)

        fetchTracks("Eminem", "us")
    }

    fun fetchTracks(term: String, country: String ) {
        viewModelScope.launch {
            try {
                val response: TrackResponse = TrackApi.apiService.searchTracks(term, country)
                _tracks.value = response.results ?: emptyList()
            } catch (e: Exception) {
                Log.e("TrackViewModel", "Error: ${e.message}")
            }
        }
    }

    fun selectTrack(track: Track) {
        _selectedTrack.value = track
        playTrack(track.previewUrl)
    }

    private fun playTrack(url: String) {
        mediaPlayer?.release()

        // Ein neues MediaPlayer-Objekt wird erstellt und konfiguriert
        mediaPlayer = MediaPlayer().apply {
            setDataSource(url)
            prepare() // Bereitet den MediaPlayer vor (lädt die Daten und initialisiert den Player)
            start()
        }
        _isPlaying.value = true
    }

    private fun stopTrack() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        _isPlaying.value = false
    }

    fun togglePlayPause() {
        if (_isPlaying.value) {
            stopTrack()
        } else {
            _selectedTrack.value?.previewUrl?.let { playTrack(it) }
        }
    }
    // Methode, die aufgerufen wird, wenn das ViewModel zerstört wird
    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.release()
        mediaPlayer = null
    }


    fun nextTrack(track: Track?) {
        Log.d("TrackViewModel", "nextTrack called")
        if (currentTrackIndex < _tracks.value.size - 1) {
            currentTrackIndex++
            playTrack(track?.previewUrl ?: "")
            selectTrack(_tracks.value[currentTrackIndex])
        } else {
            currentTrackIndex = 0
        }
    }

    fun previousTrack(track: Track?) {
        Log.d("TrackViewModel", "previousTrack called")
        if (currentTrackIndex > 0) {
            currentTrackIndex--
            playTrack(track?.previewUrl ?: "")
            selectTrack(_tracks.value[currentTrackIndex])
        } else {
            currentTrackIndex = 0
        }
    }
}



