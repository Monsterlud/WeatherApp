package com.dmonsalud.weatherapp.data.remote.datasource

import com.dmonsalud.weatherapp.data.RemoteDataSource
import com.dmonsalud.weatherapp.data.WeatherService

class RemoteDataSourceImpl(
    private val weatherService: WeatherService
) : RemoteDataSource {

    override suspend fun getGeocodingResponseFromApi(
        zipCode: Int
    ): String {
        return weatherService.getGeocodingApiResponseFromZipcode(zipCode)
    }

    override suspend fun getWeatherForecastFromApi(
        lat: String,
        long: String
    ): String {
        return weatherService.getOpenWeatherApiResponse(lat, long)
    }
}
