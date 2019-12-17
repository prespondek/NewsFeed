package com.lanyard.newsfeed.dagger

import androidx.fragment.app.FragmentManager
import com.lanyard.newsfeed.MainActivity
import com.lanyard.newsfeed.views.NewsFeedFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainActivityModule.FragmentBindings::class])
class MainActivityModule {
    @Module
    interface FragmentBindings {
        @ContributesAndroidInjector(modules = [NewsFeedFragmentModule::class])
        fun bindNewsFeedFragment(): NewsFeedFragment
    }
    @Provides
    @MainActivityScope
    fun provideActivity(mainActivity: MainActivity): MainActivity = mainActivity

    @Provides
    @MainActivityScope
    fun provideFragmentManager(mainActivity: MainActivity): FragmentManager = mainActivity.supportFragmentManager
}