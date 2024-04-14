package com.dmonsalud.data.datasource

import android.accounts.NetworkErrorException
import com.dmonsalud.data.RemoteDataSource
import com.dmonsalud.data.DataConstants
import com.dmonsalud.data.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.contentType
import io.ktor.utils.io.errors.IOException

class RemoteDataSourceImpl(
    private val client: HttpClient
) : RemoteDataSource {

    override suspend fun getGeocodingResponseFromApi(zipCode: String): Result<String> {
        try {
            val geoString = client.get<String>("https://api.openweathermap.org/geo/1.0/zip") {
                contentType(Json)
                parameter("zip", zipCode)
                parameter("appid", DataConstants.GEOAPIKEY)
            }
            return Result.success(geoString)
        } catch (e: NetworkErrorException) {
            return Result.failure(DataError.Network(e))
        } catch (e: IOException) {
            return Result.failure(DataError.Network(e))
        } catch (e: Exception) {
            return Result.failure(DataError.Unknown(e))
        }

    }

    override suspend fun getWeatherResponseFromApi(lat: String, lon: String): Result<String> {
        try {
            val weatherString =
                client.get<String>("https://api.openweathermap.org/data/2.5/forecast") {
                    contentType(Json)
                    parameter("lat", lat)
                    parameter("lon", lon)
                    parameter("appid", DataConstants.WEATHERAPIKEY)
                }
            return Result.success(weatherString)
        } catch (e: HttpException) {
            return Result.failure(DataError.Network(e))
        } catch (e: IOException) {
            return Result.failure(DataError.Network(e))
        } catch (e: Exception) {
            return Result.failure(DataError.Unknown(e))
        }
    }
}
