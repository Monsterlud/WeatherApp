package com.dmonsalud.weatherapp.data

interface RemoteDataSource {

    suspend fun getGeocodingResponseFromApi(zipCode: String): String?

    suspend fun getWeatherResponseFromApi(lat: String, lon: String): String?
}