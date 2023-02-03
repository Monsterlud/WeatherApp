package com.dmonsalud.weatherapp.presentation

interface WeatherListRepository {

    fun cacheWeatherResponseJsonToSharedPrefs(value: String?)

    fun retrieveWeatherResponseJsonFromSharedPrefs(): String?

    suspend fun getGeocodingResponseJson(zipCode: Int): String?

    suspend fun getWeatherResponseJsonFromOpenWeatherApi(long: String, lat: String): String?

}