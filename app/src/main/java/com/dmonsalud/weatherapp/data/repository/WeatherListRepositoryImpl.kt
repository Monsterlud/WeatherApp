package com.dmonsalud.weatherapp.data.repository

import android.content.Context
import com.dmonsalud.weatherapp.data.local.datasource.LocalDataSourceImpl
import com.dmonsalud.weatherapp.presentation.WeatherListRepository

class WeatherListRepositoryImpl(
    context: Context
) : WeatherListRepository {

    private val localDataSourceImpl = LocalDataSourceImpl(context)

    override fun cacheWeatherResponseJson(key: String, value: String) {
        localDataSourceImpl.saveWeatherPref(key, value)
    }

    override fun retrieveWeatherResponseJson(key: String): String? {
        return localDataSourceImpl.getWeatherPref(key)

    }
}