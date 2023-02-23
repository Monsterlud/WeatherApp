package com.dmonsalud.weatherapp.presentation

import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface WeatherListRepository {

    suspend fun cacheWeatherResponseJson(value: String?)

    fun retrieveWeatherResponseJson(): Flow<List<WeatherEntity>>

    suspend fun getGeocodingResponseJson(zipCode: String): String?

    suspend fun getWeatherResponseJson(lat: String, lon: String): String?

}