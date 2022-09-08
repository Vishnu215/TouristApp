package com.tourist.android.touristclone.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.tourist.android.touristclone.models.RemoteKeys

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = REPLACE)
    suspend fun saveRedditKeys(redditKey: RemoteKeys)

    @Query("SELECT * FROM redditKeys ORDER BY id DESC")
    suspend fun getRedditKeys(): List<RemoteKeys>

}