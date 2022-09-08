package com.tourist.android.touristclone.repositories

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tourist.android.touristclone.database.RoomDatabase
import com.tourist.android.touristclone.models.TouristPost
import com.tourist.android.touristclone.networking.TouristClient
import com.tourist.android.touristclone.networking.TouristService
import kotlinx.coroutines.flow.Flow

class TouristRepo(context: Context) {
    private val redditService = TouristClient.getClient().create(TouristService::class.java)
    private val redditDatabase = RoomDatabase.create(context)

    @OptIn(ExperimentalPagingApi::class)
    fun fetchPosts(): Flow<PagingData<TouristPost>> {
        return Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3),
            remoteMediator = TouristRemoteMediator(redditService, redditDatabase as RoomDatabase),
            pagingSourceFactory = { redditDatabase.redditPostsDao().getPosts() }
        ).flow
    }
}