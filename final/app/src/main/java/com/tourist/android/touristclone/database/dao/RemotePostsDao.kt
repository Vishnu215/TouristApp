package com.tourist.android.touristclone.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.tourist.android.touristclone.models.TouristPost

@Dao
interface RemotePostsDao {

    @Insert(onConflict = REPLACE)
    suspend fun savePosts(redditPosts: List<TouristPost>)

    @Query("SELECT * FROM tourist")
    fun getPosts(): PagingSource<Int, TouristPost>

}