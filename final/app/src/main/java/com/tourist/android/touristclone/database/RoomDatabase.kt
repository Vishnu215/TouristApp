package com.tourist.android.touristclone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tourist.android.touristclone.database.dao.RemoteKeysDao
import com.tourist.android.touristclone.database.dao.RemotePostsDao
import com.tourist.android.touristclone.models.RemoteKeys
import com.tourist.android.touristclone.models.TouristPost

@Database(
    entities = [TouristPost::class, RemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDatabase : RoomDatabase() {
    companion object {
        fun create(context: Context): RoomDatabase {
            val databaseBuilder =
                Room.databaseBuilder(context, RoomDatabase::class.java, "redditclone.db")
            return databaseBuilder.build()
        }
    }

    abstract fun redditPostsDao(): RemotePostsDao
    abstract fun redditKeysDao(): RemoteKeysDao
}