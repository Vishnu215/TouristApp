package com.tourist.android.touristclone.utils

import androidx.recyclerview.widget.DiffUtil
import com.tourist.android.touristclone.models.TouristPost

class DiffUtilCallBack : DiffUtil.ItemCallback<TouristPost>() {
    override fun areItemsTheSame(oldItem: TouristPost, newItem: TouristPost): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TouristPost, newItem: TouristPost): Boolean {
        return oldItem.id == newItem.id
                && oldItem.tourist_name == newItem.tourist_name
                && oldItem.tourist_email == newItem.tourist_email
                && oldItem.tourist_location == newItem.tourist_location
                && oldItem.createdat == newItem.createdat
    }
}