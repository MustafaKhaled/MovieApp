package com.movieapp.kotlin

import android.app.Application
import com.movieapp.kotlin.di.MoviesModules
import com.movieapp.kotlin.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(NetworkModule,MoviesModules))
        }
    }

}