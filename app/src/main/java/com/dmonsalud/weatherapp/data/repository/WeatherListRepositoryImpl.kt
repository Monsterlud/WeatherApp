package com.dmonsalud.weatherapp.data.repository

import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.data.RemoteDataSource
import com.dmonsalud.weatherapp.presentation.WeatherListRepository

class WeatherListRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : WeatherListRepository {

    /**
     * Local Data From Room
     */

    override suspend fun cacheWeatherResponseJson(value: String?) {
        if (!value.isNullOrEmpty()) {
            return localDataSource.saveWeatherForecast(value)
        } else {
            throw Exception("Cannot save null value or empty string.")
        }
    }

    override suspend fun retrieveWeatherResponseJson(): String? {
        return localDataSource.getWeatherForecast()
    }

    /**
     * Remote Data From APIs
     */

    override suspend fun getGeocodingResponseJson(
        zipCode: Int
    ): String? {
        return remoteDataSource.getGeocodingResponseFromApi(zipCode)
    }

    override suspend fun getWeatherResponseJson(
        lat: String,
        lon: String
    ): String? {
        return remoteDataSource.getWeatherForecastFromApi(lat, lon)
    }
}