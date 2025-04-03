package com.example.a04_11_abschluss.repository

import android.util.Log
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.model.TrackResponse
import com.example.a04_11_abschluss.remote.TrackApiService

import com.example.soundsnap.data.TrackDao
import com.example.soundsnap.data.TrackFavorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

interface TrackRepositoryInterface {
    // Datasource Local Database

    suspend fun getTrackById(trackId: String): TrackResponse

    suspend fun insertTrack(track: Track)

    suspend fun deleteTrack(track: Track)

    suspend fun updateTrack(track: Track)

    fun getAllFavoriteTrack(): Flow<List<TrackFavorite>>


}

class TrackRepositoryImpl(
    private val trackApiService: TrackApiService,
    private val trackDao: TrackDao
) : TrackRepositoryInterface {

    override suspend fun getTrackById(trackId: String): TrackResponse {
        return trackApiService.getTrackById(trackId)

    }


    // Datasource Local TrackDatabase
    override suspend fun insertTrack(track: Track) {
        Log.d("TrackRepositoryImpl", "Inserting track: $track")
        val trackFavorite = TrackFavorite.convert(track)
        trackDao.insertTrack(trackFavorite)
    }

    override suspend fun deleteTrack(track: Track) {
        Log.d("TrackRepositoryImpl", "Deleting track: $track")
        val trackFavorite = TrackFavorite.convert(track)
        trackDao.deleteTrack(trackFavorite)
    }
    override suspend fun updateTrack(track: Track) {
        Log.d("TrackRepositoryImpl", "Updating track: $track")
        val trackFavorite = TrackFavorite.convert(track)
        trackDao.updateTrack(trackFavorite)
    }

    override fun getAllFavoriteTrack(): Flow<List<TrackFavorite>> {
        try {
            return trackDao.getAllFavoriteTracks()
        } catch (e: Exception) {
            Log.e("TrackRepositoryImpl", "Error getting all favorite tracks: ${e.message}")
            return emptyFlow()
        }
    }
}
