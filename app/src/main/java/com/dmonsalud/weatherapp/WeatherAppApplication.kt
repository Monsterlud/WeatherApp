package com.dmonsalud.weatherapp

import android.app.Application
import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherDatabase
import com.dmonsalud.weatherapp.di.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherAppApplication)
            modules(listOf(koinModule))
        }
    }

    companion object {
        private lateinit var instance: WeatherAppApplication
        private val database: WeatherDatabase by lazy {
            WeatherDatabase.getDatabase(instance)
        }
    }
}
