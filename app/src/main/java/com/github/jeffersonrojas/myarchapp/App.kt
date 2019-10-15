package com.github.jeffersonrojas.myarchapp

import android.app.Application
import com.github.jeffersonrojas.myarchapp.common.data.di.networkModule
import com.github.jeffersonrojas.myarchapp.data.di.roomModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    fun initDI() {
        startKoin {
            androidContext(this@App)
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.DEBUG
                } else {
                    Level.INFO
                }
            )
            modules(networkModule)
            modules(roomModule)
        }
    }
}
