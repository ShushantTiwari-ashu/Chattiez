package com.shushant.astroyoga

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder
import com.shushant.astroyoga.di.appModule
import com.shushant.astroyoga.operator.GlobalResponseOperator
import com.shushant.chattiez.auth.di.dataModule
import com.shushant.chattiez.data.datastore.datastoreModule
import com.shushant.chattiez.network.di.firebaseModule
import com.shushant.chattiez.splash.di.onBoardingModule
import com.shushant.navigation.di.navigationModule
import com.skydoves.sandwich.SandwichInitializer
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class AstroYoga : Application(), ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        SandwichInitializer.sandwichOperators += GlobalResponseOperator<Any>(this)
        startKoin {
            androidLogger()
            androidContext(this@AstroYoga)
            modules(
                navigationModule, appModule, datastoreModule, dataModule, firebaseModule,onBoardingModule
            )
        }
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this).components {
            add(SvgDecoder.Factory())
        }.build()
    }
}