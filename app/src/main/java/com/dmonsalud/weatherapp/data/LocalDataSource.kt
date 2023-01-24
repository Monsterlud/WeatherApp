package com.dmonsalud.weatherapp.data

interface LocalDataSource {

    fun saveWeatherForecast(value: String?)

    fun getWeatherForecast(): String?
}