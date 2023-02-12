package com.dmonsalud.weatherapp.data

interface LocalDataSource {

    suspend fun saveWeatherForecast(value: String?)

    suspend fun getWeatherForecast(): String?
}