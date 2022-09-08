package com.tourist.android.touristclone.repositories

import androidx.paging.PagingSource
import com.tourist.android.touristclone.models.TouristPost
import com.tourist.android.touristclone.networking.TouristService
import retrofit2.HttpException
import java.io.IOException

class TouristPagingSource(private val redditService: TouristService) :
    PagingSource<String, TouristPost>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, TouristPost> {
        return try {
            val response = redditService.fetchPosts(loadSize = params.loadSize)
            val listing = response.body()?.data
            val redditPosts = listing?.children?.map { it.data }
            LoadResult.Page(
                redditPosts ?: listOf(),
                listing?.before,
                listing?.after
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override val keyReuseSupported: Boolean = true
}