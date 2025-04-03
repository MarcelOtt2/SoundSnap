package com.example.soundsnap.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.a04_11_abschluss.model.Track
import com.squareup.moshi.Json

@androidx.room.Entity(tableName = "track_favorite_table")
data class TrackFavorite(
    @androidx.room.PrimaryKey(autoGenerate = false)
    val trackId: String ,
    val trackName: String,
    val artistName: String,
@Json(name = "artworkUrl100")
    val imageUrl: String,
    val previewUrl: String,
    val collectionName: String ,
    val releaseDate: String ,
    val primaryGenreName: String ,
    val country: String ,
    val isFavorite: Boolean = false
) {
    companion object {
        fun convert(track: Track): TrackFavorite {
            return TrackFavorite(
                trackId = track.trackId,
                trackName = track.trackName,
                artistName = track.artistName,
                imageUrl = track.imageUrl,
                previewUrl = track.previewUrl,
                collectionName = track.collectionName,
                releaseDate = track.releaseDate,
                primaryGenreName = track.primaryGenreName,
                country = track.country,
                isFavorite = true,

            )
        }
    }
}
