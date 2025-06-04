package com.example.sivalet

import android.app.Application
import com.example.sivalet.di.appModule
import org.koin.core.context.startKoin

class SiValetApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}