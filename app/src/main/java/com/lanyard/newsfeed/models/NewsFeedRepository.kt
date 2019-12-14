package com.lanyard.newsfeed.models

import androidx.lifecycle.LiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.lifecycle.MutableLiveData
import com.lanyard.newsfeed.libraries.NetworkApiResponse
import com.lanyard.newsfeed.libraries.UNKNOWN_CODE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object NewsFeedRepository {
    private val mutableLiveData = MutableLiveData<NetworkApiResponse<NewsFeedData>>()
    private var networkCall : Call<NewsFeedData>? = null

    fun fetchNewsFeedData() : LiveData<NetworkApiResponse<NewsFeedData>>
    {
        if (networkCall != null) {
            return mutableLiveData
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(NewsFeedService::class.java)
        networkCall = service.fetchNewsFeedData()
        networkCall?.enqueue(object : Callback<NewsFeedData> {
            override fun onResponse(call: Call<NewsFeedData>, response: Response<NewsFeedData>) {
                mutableLiveData.value = NetworkApiResponse.create(response)
                networkCall = null
            }
            override fun onFailure(call: Call<NewsFeedData>, t: Throwable) {
                mutableLiveData.value = NetworkApiResponse.create<NewsFeedData>(UNKNOWN_CODE, t)
                networkCall = null
            }
        })
        return mutableLiveData;
    }
}