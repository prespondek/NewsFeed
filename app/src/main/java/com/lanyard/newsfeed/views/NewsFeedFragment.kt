package com.lanyard.newsfeed.views

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.lanyard.newsfeed.databinding.FragmentNewsfeedBinding
import com.lanyard.newsfeed.viewmodels.NewsFeedViewModel
import com.lanyard.newsfeed.views.adapters.NewsItemAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class NewsFeedFragment : Fragment() {

    @Inject
    lateinit var viewModel: NewsFeedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentNewsfeedBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = NewsItemAdapter()
        binding.newsItemList.adapter = adapter
        binding.jobRefresh.setOnRefreshListener {
            adapter.submitList(listOf())
            viewModel.fetchNewsFeedData()
        }
        subscribeUi(adapter,binding)

        return binding.root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private fun subscribeUi(adapter: NewsItemAdapter, binding: FragmentNewsfeedBinding) {
        viewModel.fetchNewsFeedData().observe(viewLifecycleOwner) { newsItems ->
            adapter.submitList(newsItems)
            binding.progressBar.visibility = View.GONE
            binding.jobRefresh.isRefreshing = false
        }
    }

}