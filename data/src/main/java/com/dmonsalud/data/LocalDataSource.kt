package com.dmonsalud.data

import com.dmonsalud.data.datasource.room.WeatherEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun saveWeatherForecast(value: String?)

    fun getWeatherForecast(): Flow<List<WeatherEntity>>
}