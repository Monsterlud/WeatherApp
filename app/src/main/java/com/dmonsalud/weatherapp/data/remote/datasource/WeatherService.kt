package com.dmonsalud.weatherapp.data.remote.datasource

interface WeatherService {

    suspend fun getGeocodingApiResponseFromZipcode(
        zipCode: Int
    ): String

    suspend fun getOpenWeatherApiResponse(
        long: String,
        lat: String
    ): String
}