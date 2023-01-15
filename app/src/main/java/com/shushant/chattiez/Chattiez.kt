package com.shushant.chattiez

import android.app.Application
import com.shushant.chattiez.data.datastore.datastoreModule
import com.shushant.navigation.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class Chattiez : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            androidContext(this@Chattiez)
            modules(
                listOf(
                    navigationModule, datastoreModule
                )
            )
        }
    }
}