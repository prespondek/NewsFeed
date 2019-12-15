package com.lanyard.newsfeed.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lanyard.newsfeed.models.NewsFeedRepository
import com.lanyard.newsfeed.models.NewsFeedRow
import androidx.lifecycle.switchMap
import com.lanyard.newsfeed.libraries.NetworkApiSuccessResponse

class NewsFeedViewModel : ViewModel() {
    val newsItems: LiveData<List<NewsFeedRow>> = NewsFeedRepository.fetchNewsFeedData().switchMap {
        val response = it as? NetworkApiSuccessResponse
        if (response != null) {
            MutableLiveData<List<NewsFeedRow>>(response.body.rows)
        }
        MutableLiveData<List<NewsFeedRow>>()
    }
}