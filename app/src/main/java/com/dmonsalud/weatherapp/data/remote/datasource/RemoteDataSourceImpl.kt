package com.dmonsalud.weatherapp.data.remote.datasource

import com.dmonsalud.weatherapp.data.RemoteDataSource
import com.dmonsalud.weatherapp.model.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType

class RemoteDataSourceImpl(
    private val client: HttpClient
) : RemoteDataSource {

    // http://api.openweathermap.org/geo/1.0/zip?zip=[zipcode],US&appid=[api key]
    // http://api.openweathermap.org/data/2.5/forecast?lat=[lat]&lon=[lon]&appid=[api key]

    override suspend fun getGeocodingResponseFromApi(zipCode: Int): String {
        val geoString = client.use {
            client.get<String> {
                url("http://api.openweathermap.org/geo/1.0/zip?zip=$zipCode,US&appid=${Constants.GEOAPIKEY}") {
                    protocol = URLProtocol.HTTP
//                    parameter("zip", zipCode)
//                    parameter("country", "US")
//                    parameter("appid", Constants.GEOAPIKEY)

                }
                contentType(ContentType.Application.Json)
            }
        }
        return geoString
    }


    override suspend fun getWeatherForecastFromApi(lat: String, long: String): String {
        val weatherString = client.use {
            client.get<String> {
                url("http://api.openweathermap.org/data/2.5/forecast?lat=$lat&lon=$long&appid=${Constants.WEATHERAPIKEY}") {
                    protocol = URLProtocol.HTTP

//                    parameter("lat", lat)
//                    parameter("lon", long)
//                    parameter("appid", Constants.WEATHERAPIKEY)
                }
                contentType(ContentType.Application.Json)
            }
        }
        return weatherString
    }
}
