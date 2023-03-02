package com.dmonsalud.weatherapp.data.remote.datasource

import com.dmonsalud.weatherapp.data.RemoteDataSource
import com.dmonsalud.weatherapp.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.contentType

class RemoteDataSourceImpl(
    private val client: HttpClient
) : RemoteDataSource {

    override suspend fun getGeocodingResponseFromApi(zipCode: String): String {
        val geoString = client.get<String>("https://api.openweathermap.org/geo/1.0/zip") {
            contentType(Json)
            parameter("zip", zipCode)
            parameter("appid", Constants.GEOAPIKEY)
        }
        return geoString
    }

    override suspend fun getWeatherResponseFromApi(lat: String, lon: String): String {
        val weatherString = client.get<String>("https://api.openweathermap.org/data/2.5/forecast") {
            contentType(Json)
            parameter("lat", lat)
            parameter("lon", lon)
            parameter("appid", Constants.WEATHERAPIKEY)
        }
        return weatherString
    }
}
