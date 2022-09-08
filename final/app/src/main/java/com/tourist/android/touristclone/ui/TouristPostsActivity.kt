package com.tourist.android.touristclone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.tourist.android.touristclone.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TouristPostsActivity : AppCompatActivity() {
    private val redditAdapter = TouristAdapter()
    private val redditViewModel: TouristViewModel by lazy {
        ViewModelProvider(this).get(TouristViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        fetchPosts()
    }

    private fun fetchPosts() {
        lifecycleScope.launch {
            redditViewModel.fetchPosts().collectLatest { pagingData ->
                redditAdapter.submitData(pagingData)
            }
        }

    }

    private fun setupViews() {
        rvPosts.adapter = redditAdapter
        rvPosts.adapter = redditAdapter.withLoadStateHeaderAndFooter(
            header = TouristLoadingAdapter { redditAdapter.retry() },
            footer = TouristLoadingAdapter { redditAdapter.retry() }
        )
    }
}