package com.dmonsalud.weatherapp.data

interface LocalDataSource {

    fun saveWeatherForecast(key: String, value: String)

    fun getWeatherForecast(key: String): String?
}