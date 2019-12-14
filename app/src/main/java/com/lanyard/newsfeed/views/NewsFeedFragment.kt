package com.lanyard.newsfeed.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lanyard.newsfeed.viewmodels.NewsFeedViewModel

class NewsFeedFragment : Fragment() {

    private val viewModel: NewsFeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}