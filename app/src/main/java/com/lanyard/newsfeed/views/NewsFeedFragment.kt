package com.lanyard.newsfeed.views

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.lanyard.newsfeed.databinding.FragmentNewsfeedBinding
import com.lanyard.newsfeed.viewmodels.NewsFeedViewModel
import com.lanyard.newsfeed.views.adapters.NewsItemAdapter

class NewsFeedFragment : Fragment() {

    private val viewModel: NewsFeedViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentNewsfeedBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = NewsItemAdapter()
        binding.newsItemList.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: NewsItemAdapter) {
        viewModel.newsItems.observe(viewLifecycleOwner) { newsItems ->
            adapter.submitList(newsItems)
        }
    }

}