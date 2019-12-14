package com.lanyard.newsfeed.models

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface NewsFeedService {
    @GET("facts.json")
    fun fetchNewsFeedData(): Call<NewsFeedData>
}

class NewsFeedData {
    @SerializedName("title")
    var title: String = ""
    @SerializedName("rows")
    var rows = ArrayList<NewsFeedRow>()
}

class NewsFeedRow {
    @SerializedName("title")
    var title: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("imageHref")
    var imageHref: String? = null
}