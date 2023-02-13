package com.dmonsalud.weatherapp.data

interface RemoteDataSource {

    suspend fun getGeocodingResponseFromApi(zipCode: Int): String?

    suspend fun getWeatherForecastFromApi(lat: String, lon: String): String?
}