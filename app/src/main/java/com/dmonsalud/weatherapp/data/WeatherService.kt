package com.dmonsalud.weatherapp.data

interface WeatherService {

    suspend fun getGeocodingApiResponseFromZipcode(
        zipCode: Int
    ): String

    suspend fun getOpenWeatherApiResponse(
        long: String,
        lat: String
    ): String
}