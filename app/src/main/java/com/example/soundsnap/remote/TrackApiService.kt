package com.example.a04_11_abschluss.remote

import com.example.a04_11_abschluss.model.TrackResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.jvm.java
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.getValue

const val BASE_URL = "https://itunes.apple.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface TrackApiService {
    @GET("search")
    suspend fun searchTracks(
        @Query("term") term: String,
        @Query("country") country: String = "de",
        @Query("media") media: String = "music",
    ): TrackResponse

    @GET("search")
    suspend fun getTrackById(
        @Query("id") id: String
    ): TrackResponse

}

object TrackApi {
    val apiService: TrackApiService by lazy { retrofit.create(TrackApiService::class.java) }


}
