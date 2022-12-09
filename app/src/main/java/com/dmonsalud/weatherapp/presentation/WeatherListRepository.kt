package com.dmonsalud.weatherapp.presentation

interface WeatherListRepository {

    fun cacheWeatherResponseJson(key: String, value: String)

    fun retrieveWeatherResponseJson(key: String): String?
}