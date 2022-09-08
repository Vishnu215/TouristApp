
package com.tourist.android.touristclone.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TouristClient {
    companion object {
        private const val BASE_URL = "http://restapi.adequateshop.com/"
        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit {
            when (retrofit) {
                null -> retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit as Retrofit
        }
    }
}