package com.tourist.android.touristclone.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "redditKeys")
data class RemoteKeys(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val after: String?,
    val before: String?
)
