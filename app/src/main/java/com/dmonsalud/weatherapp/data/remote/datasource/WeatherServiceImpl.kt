package com.dmonsalud.weatherapp.data.remote.datasource

import com.dmonsalud.weatherapp.data.WeatherService
import com.dmonsalud.weatherapp.model.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.contentType

class WeatherServiceImpl(
    private val client: HttpClient
) : WeatherService {

    // http://api.openweathermap.org/geo/1.0/zip?zip=[zipcode],US&appid=[api key]
    // http://api.openweathermap.org/data/2.5/forecast?lat=[lat]&lon=[lon]&appid=[api key]

    override suspend fun getGeocodingApiResponseFromZipcode(zipCode: Int): String {
        val geoString = client.get<String> {
            url( Constants.GEO_BASE_URL + Constants.GEO_ZIP_ENDPOINT)
            contentType(Json)
            parameter("zip", zipCode)
            parameter("country", "US")
            parameter("appid", Constants.GEOAPIKEY)
        }.toString()
        client.close()
        return geoString
    }

    override suspend fun getOpenWeatherApiResponse(lat: String, long: String): String {
        val weatherString = client.get<String> {
            url(Constants.WEATHER_BASE_URL + Constants.WEATHER_FIVE_DAY_ENDPOINT)
            parameter("lat", lat)
            parameter("lon", long)
            parameter("appid", Constants.WEATHERAPIKEY)
        }.toString()
        client.close()
        return weatherString
    }
}