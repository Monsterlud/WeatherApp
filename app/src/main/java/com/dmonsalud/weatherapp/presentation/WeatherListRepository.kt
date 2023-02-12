package com.dmonsalud.weatherapp.presentation

interface WeatherListRepository {

    suspend fun cacheWeatherResponseJson(value: String?)

    suspend fun retrieveWeatherResponseJson(): String?

    suspend fun getGeocodingResponseJson(zipCode: Int): String?

    suspend fun getWeatherResponseJson(lat: String, lon: String): String?

}