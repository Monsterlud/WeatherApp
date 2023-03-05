package com.dmonsalud.weatherapp

import android.app.Application
import com.dmonsalud.weatherapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherAppApplication)
            modules(
                listOf(
                    appModule
                )
            )
        }
    }
}
