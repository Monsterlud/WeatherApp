package com.dmonsalud.weatherapp.presentation

import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherEntity
import com.dmonsalud.weatherapp.utils.GeocodingApiResponse
import kotlinx.coroutines.flow.Flow

interface WeatherListRepository {

    suspend fun cacheWeatherResponseJson(value: String?)

    fun retrieveWeatherResponseJson(): Flow<List<WeatherEntity>>

    suspend fun getAndSaveFiveDayWeatherForecast(zipCode: String) : String

    suspend fun getGeocodingResponseJson(zipCode: String) : String?

    suspend fun getWeatherResponseJson(lat: Double, lon: Double): String?

}