package com.dmonsalud.data

import com.dmonsalud.data.datasource.room.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface WeatherListRepository {

    suspend fun cacheWeatherResponseJson(value: String?)

    fun retrieveWeatherResponseJson(): Flow<List<WeatherEntity>>

    suspend fun getAndSaveFiveDayWeatherForecast(zipCode: String) : String

    suspend fun getGeocodingResponseJson(zipCode: String) : String?

    suspend fun getWeatherResponseJson(lat: Double, lon: Double): String?

}