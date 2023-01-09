package com.dmonsalud.weatherapp.data.repository

import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.presentation.WeatherListRepository

class WeatherListRepositoryImpl(
    private val localDataSource: LocalDataSource
) : WeatherListRepository {

    override fun cacheWeatherResponseJson(value: String) {
        return localDataSource.saveWeatherForecast(value)
    }

    override fun retrieveWeatherResponseJson(): String? {
        return localDataSource.getWeatherForecast()
    }
}