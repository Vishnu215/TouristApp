package com.tourist.android.touristclone.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tourist")
data class TouristPost(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("name")
    val tourist_name: String,
    @SerializedName("email")
    val tourist_email: String,
    @SerializedName("location")
    val tourist_location: String,
    @SerializedName("date")
    val createdat: String
)
