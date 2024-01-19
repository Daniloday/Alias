package com.missclick.alies

import android.app.Application
import com.missclick.alies.di.appModule
import com.missclick.alies.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

    }

}