package com.tourist.android.touristclone.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.tourist.android.touristclone.models.TouristPost
import com.tourist.android.touristclone.repositories.TouristRepo
import kotlinx.coroutines.flow.Flow

class TouristViewModel(application: Application) : AndroidViewModel(application) {
    private val redditRepo = TouristRepo(application)

    fun fetchPosts(): Flow<PagingData<TouristPost>> {
        return redditRepo.fetchPosts().cachedIn(viewModelScope)
    }
}