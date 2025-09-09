package com.example.ministryoffinance

import android.app.Application
import com.example.ministryoffinance.appModules.appModule
import com.example.ministryoffinance.appModules.fakeAppModule
import com.example.ministryoffinance.appModules.networkModule
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