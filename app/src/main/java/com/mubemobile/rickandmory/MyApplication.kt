package com.mubemobile.rickandmory

import android.app.Application
import com.mubemobile.rickandmory.di.appModule
import com.mubemobile.rickandmory.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level =Level.NONE)
            androidContext(this@MyApplication)
            modules(listOf(appModule, networkModule))
        }
    }
}
