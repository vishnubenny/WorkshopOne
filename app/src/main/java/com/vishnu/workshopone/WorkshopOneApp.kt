package com.vishnu.workshopone

import android.app.Application
import com.vishnu.workshopone.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WorkshopOneApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@WorkshopOneApp)
            // declare modules
            modules(appModule)
        }
    }
}
