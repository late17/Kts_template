package com.example.kts_template.app

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@HiltAndroidApp
class App : Application() {

    @Module
    @InstallIn(ActivityComponent::class)
    object DataModule {

        @Provides
        @Singleton
        fun providesClass(): Int {
            return 2
        }
    }
}