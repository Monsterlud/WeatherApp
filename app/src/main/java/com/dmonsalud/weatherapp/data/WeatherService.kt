package com.dmonsalud.weatherapp.data

interface WeatherService {

    suspend fun getGeocodingApiResponseFromZipcode(
        zipCode: Int
    ): String

    suspend fun getOpenWeatherApiResponse(
        lat: String,
        long: String
    ): String
}