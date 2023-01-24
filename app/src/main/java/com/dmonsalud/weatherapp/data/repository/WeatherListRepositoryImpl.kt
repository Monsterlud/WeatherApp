package com.dmonsalud.weatherapp.data.repository

import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.presentation.WeatherListRepository

class WeatherListRepositoryImpl(
    private val localDataSource: LocalDataSource
) : WeatherListRepository {

    override fun cacheWeatherResponseJson(value: String?) {
        if (!value.isNullOrEmpty()) {
            return localDataSource.saveWeatherForecast(value)
        } else {
            throw Exception("Cannot save null value or empty string.")
        }
    }

    override fun retrieveWeatherResponseJson(): String? {
        return localDataSource.getWeatherForecast()
    }
}