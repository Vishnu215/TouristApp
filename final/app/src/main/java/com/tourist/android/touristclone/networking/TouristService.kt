package com.tourist.android.touristclone.networking
import com.tourist.android.touristclone.models.TouristApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TouristService {

    @GET("api/Tourist")
    suspend fun fetchPosts(
        @Query("page") page:Int= 0,
        @Query("limit") loadSize: Int = 0,
        @Query("after") after: String? = null,
        @Query("before") before: String? = null
    ): Response<TouristApiResponse>
}