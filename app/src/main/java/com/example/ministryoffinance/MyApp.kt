package com.example.ministryoffinance

import android.app.Application
import com.example.ministryoffinance.di.fakeAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(fakeAppModule)
        }
    }
}