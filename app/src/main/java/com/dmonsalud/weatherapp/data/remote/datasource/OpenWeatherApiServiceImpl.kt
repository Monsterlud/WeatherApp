package com.dmonsalud.weatherapp.data.remote.datasource

import com.dmonsalud.weatherapp.model.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class WeatherServiceImpl(
    private val client: HttpClient
) : WeatherService {

    override suspend fun getGeocodingApiResponseFromZipcode(
        zipcode: Int
    ): String {
        return client.get {
            url("${Constants.GEO_ZIP_ENDPOINT}zip?zip=$zipcode,US&appid=${Constants.GEOAPIKEY}")
        }.toString()
    }

    override suspend fun getOpenWeatherApiResponse(
        long: String,
        lat: String
    ): String {
        return client.get {
            url("${Constants.WEATHER_FIVE_DAY_ENDPOINT}2.5/forecast?lat=$lat&lon=$long&appid=${Constants.WEATHERAPIKEY}")
        }.toString()
    }
}