package com.dmonsalud.weatherapp.presentation

interface WeatherListRepository {

    fun cacheWeatherResponseJson(value: String)

    fun retrieveWeatherResponseJson(): String?
}