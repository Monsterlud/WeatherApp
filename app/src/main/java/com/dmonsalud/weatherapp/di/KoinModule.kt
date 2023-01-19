package com.dmonsalud.weatherapp.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.data.local.datasource.LocalDataSourceImpl
import com.dmonsalud.weatherapp.data.repository.WeatherListRepositoryImpl
import com.dmonsalud.weatherapp.model.Constants
import com.dmonsalud.weatherapp.presentation.WeatherListRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.bind
import org.koin.dsl.module

val koinModule = module {
    single { getSharedPreferences(androidApplication()) }
    single { LocalDataSourceImpl(get()) } bind LocalDataSource::class
    single { WeatherListRepositoryImpl( get()) } bind (WeatherListRepository::class)
}

private fun getSharedPreferences(application: Application): SharedPreferences {
    return application.getSharedPreferences(
        Constants.WEATHER_PREFERENCES, Context.MODE_PRIVATE
    )
}