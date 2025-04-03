package com.example.soundsnap.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.also
import kotlin.jvm.java

@Database(entities = [TrackFavorite::class], version = 3 , exportSchema = false)
abstract class TrackDatabase: RoomDatabase(){
    abstract val dao: TrackDao

    companion object {
        private var dbInstance: TrackDatabase? = null

        fun getDatabase(context: Context): TrackDatabase {
            return dbInstance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = TrackDatabase::class.java,
                    name = "track_favorite_database"
                ).build().also { dbInstance = it }
            }
        }
    }
}


