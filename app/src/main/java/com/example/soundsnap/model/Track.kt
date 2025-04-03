package com.example.a04_11_abschluss.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class TrackResponse(
    val results: List<Track>? = listOf(),
    val tracks: List<Track>? = listOf()
)

@Entity(tableName = "track_table")
data class Track(
    @PrimaryKey(autoGenerate = false)
    val trackId: String = "",
    val trackName: String = "",
    val artistName: String = "",
    @Json(name = "artworkUrl100")
    val imageUrl: String = "",
    val previewUrl: String = "",
    val collectionName: String = "",
    val releaseDate: String = "",
    val primaryGenreName: String = "",
    val country: String = "",
    val trackViewUrl: String = "",

)