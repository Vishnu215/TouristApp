package com.tourist.android.touristclone.repositories

import androidx.paging.*
import androidx.room.withTransaction
import com.tourist.android.touristclone.database.RoomDatabase
import com.tourist.android.touristclone.models.RemoteKeys
import com.tourist.android.touristclone.models.TouristPost
import com.tourist.android.touristclone.networking.TouristService
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class TouristRemoteMediator(
    private val redditService: TouristService,
    private val redditDatabase: RoomDatabase
) : RemoteMediator<Int, TouristPost>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TouristPost>
    ): MediatorResult {
        return try {
            val loadKey = when(loadType){
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND ->{
                    state.lastItemOrNull()
                        ?: return MediatorResult.Success(endOfPaginationReached = true)
                    getRedditKeys()
                }
            }
            val response = redditService.fetchPosts(
                loadSize = state.config.pageSize,
                after = loadKey?.after,
                before = loadKey?.before
            )
            val listing = response.body()?.data
            val redditPosts = listing?.children?.map { it.data }
            if (redditPosts != null) {
                redditDatabase.withTransaction {
                    redditDatabase.redditKeysDao()
                        .saveRedditKeys(RemoteKeys(0, listing.after, listing.before))
                    redditDatabase.redditPostsDao().savePosts(redditPosts)
                }

            }
            MediatorResult.Success(endOfPaginationReached = listing?.after == null)

        } catch (exception: IOException) {
            MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            MediatorResult.Error(exception)
        }

    }

    private suspend fun getRedditKeys(): RemoteKeys? {
        return redditDatabase.redditKeysDao().getRedditKeys().firstOrNull()

    }
}