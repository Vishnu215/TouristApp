package com.tourist.android.touristclone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tourist.android.touristclone.R
import com.tourist.android.touristclone.models.TouristPost
import com.tourist.android.touristclone.utils.DiffUtilCallBack
import kotlinx.android.synthetic.main.adapter_row.view.*

class TouristAdapter :
    PagingDataAdapter<TouristPost, TouristAdapter.RedditViewHolder>(DiffUtilCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_row, parent, false)
        return RedditViewHolder(view)
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        getItem(position)?.let { holder.bindPost(it) }
    }

    class RedditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.name
        private val email: TextView = itemView.email
        private val location: TextView = itemView.location

        fun bindPost(redditPost: TouristPost) {
            with(redditPost) {
                name.text = name.toString()
                email.text = email.toString()
                location.text = location.toString()

            }
        }
    }
}