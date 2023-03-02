package com.dmonsalud.weatherapp.data

import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun saveWeatherForecast(value: String?)

    fun getWeatherForecast(): Flow<List<WeatherEntity>>
}