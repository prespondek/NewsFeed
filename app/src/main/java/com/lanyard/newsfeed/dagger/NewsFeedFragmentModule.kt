package com.lanyard.newsfeed.dagger

import com.lanyard.newsfeed.viewmodels.NewsFeedViewModel
import dagger.Module
import dagger.Provides

@Module
class NewsFeedFragmentModule {
    @Provides
    fun provideNewsFeedViewModel(): NewsFeedViewModel = NewsFeedViewModel()
}