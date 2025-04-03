package com.example.soundsnap.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.a04_11_abschluss.model.Track
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackDao {
    @Insert
   suspend fun insertTrack(track: TrackFavorite)
   @Delete
   suspend fun deleteTrack(track: TrackFavorite)
   @Update
   suspend fun updateTrack(track: TrackFavorite)

  @Query("SELECT * FROM track_favorite_table")
   fun getAllFavoriteTracks(): Flow<List<TrackFavorite>>

}

