package com.lanyard.newsfeed.dagger

import com.lanyard.newsfeed.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module()
abstract class ActivityModule {
    @MainActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}