package com.tor.simple_back_seat

import android.app.Application
import com.tor.simple_back_seat.di.viewModelModule
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(viewModelModule))
        }
    }
}