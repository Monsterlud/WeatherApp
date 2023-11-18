package com.dmonsalud.data.repository

import com.dmonsalud.data.LocalDataSource
import com.dmonsalud.data.RemoteDataSource
import com.dmonsalud.data.WeatherListRepository
import com.dmonsalud.data.datasource.room.WeatherEntity
import com.dmonsalud.weatherapp.utils.GeocodingApiResponse
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow

class WeatherListRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val gson: Gson,
) : WeatherListRepository {

    var location: String? = null

    override suspend fun getAndSaveFiveDayWeatherForecast(zipCode: String): String {
        val geoResult =
            gson.fromJson(getGeocodingResponseJson(zipCode), GeocodingApiResponse::class.java)
        val weatherJson = getWeatherResponseJson(geoResult.lat, geoResult.lon)
        cacheWeatherResponseJson(weatherJson)
        return "${geoResult.name}, ${geoResult.country}"
    }

    /**
     * Local Data From Room
     */

    override suspend fun cacheWeatherResponseJson(value: String?) {
        if (!value.isNullOrEmpty()) {
            return localDataSource.saveWeatherForecast(value)
        } else {
            throw Exception("Cannot save null value or empty string.")
        }
    }

    override fun retrieveWeatherResponseJson(): Flow<List<WeatherEntity>> {
        return localDataSource.getWeatherForecast()
    }

    /**
     * Remote Data From APIs
     */
    override suspend fun getGeocodingResponseJson(
        zipCode: String,
    ): String? {
        return remoteDataSource.getGeocodingResponseFromApi(zipCode)
    }

    override suspend fun getWeatherResponseJson(
        lat: Double,
        lon: Double,
    ): String? {
        return remoteDataSource.getWeatherResponseFromApi(lat.toString(), lon.toString())
    }
}