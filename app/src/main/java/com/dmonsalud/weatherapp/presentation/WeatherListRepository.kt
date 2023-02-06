package com.dmonsalud.weatherapp.presentation

interface WeatherListRepository {

    fun cacheWeatherResponseJsonToSharedPrefs(value: String?)

    fun retrieveWeatherResponseJsonFromSharedPrefs(): String?

    suspend fun getGeocodingResponseJson(zipCode: Int): String?

    suspend fun getWeatherResponseJson(lat: String, long: String): String?

}