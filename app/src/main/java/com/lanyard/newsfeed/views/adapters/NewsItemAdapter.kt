package com.lanyard.newsfeed.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lanyard.newsfeed.databinding.ListItemNewsBinding
import com.lanyard.newsfeed.models.NewsFeedRow

class NewsItemAdapter : ListAdapter<NewsFeedRow, RecyclerView.ViewHolder>(NewsItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsItemViewHolder(ListItemNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val newsItem = getItem(position)
        (holder as NewsItemViewHolder).bind(newsItem)
    }

    class NewsItemViewHolder(
        private val binding: ListItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.newsItem?.let { item ->
                    // stub
                }
            }
        }

        fun bind(item: NewsFeedRow) {
            binding.apply {
                newsItem = item
                executePendingBindings()
            }
        }
    }
}

private class NewsItemDiffCallback : DiffUtil.ItemCallback<NewsFeedRow>() {

    override fun areItemsTheSame(oldItem: NewsFeedRow, newItem: NewsFeedRow): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NewsFeedRow, newItem: NewsFeedRow): Boolean {
        return oldItem == newItem
    }
}