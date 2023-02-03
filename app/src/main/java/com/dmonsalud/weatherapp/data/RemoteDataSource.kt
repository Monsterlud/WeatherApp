package com.dmonsalud.weatherapp.data

interface RemoteDataSource {

    suspend fun getGeocodingResponseFromApi(zipCode: Int): String?

    suspend fun getWeatherForecastFromApi(long: String, lat: String): String?
}