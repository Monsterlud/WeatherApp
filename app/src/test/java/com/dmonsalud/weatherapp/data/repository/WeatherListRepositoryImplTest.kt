package com.dmonsalud.weatherapp.data.repository

import com.dmonsalud.weatherapp.data.local.datasource.LocalDataSourceImpl
import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherEntity
import com.dmonsalud.weatherapp.data.remote.datasource.RemoteDataSourceImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

internal class WeatherListRepositoryImplTest {

    private val localDataSource = mockk<LocalDataSourceImpl>()
    private val remoteDataSource = mockk<RemoteDataSourceImpl>()
    private val weatherListRepository = WeatherListRepositoryImpl(localDataSource, remoteDataSource)

    private val testString = "The quick brown fox jumps over the lazy dog."
    val ZIPCODE = "80304"
    val LAT = "40"
    val LON = "-100"

    val weatherEntity1 = WeatherEntity(
        0,
        "Rick",
        100.0,
        100,
        "Sunny"
    )

    val weatherEntity2 = WeatherEntity(
        1,
        "Morty",
        50.0,
        50,
        "Freezing"
    )

    /**
     * Testing LocalDataSource
     */

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN cacheWeatherResponseJson() is called THEN saveWeatherForecast() is called from localdatasource`() {
        runTest {
            coEvery { localDataSource.saveWeatherForecast(testString) } returns Unit
            weatherListRepository.cacheWeatherResponseJson(testString)
            coVerify { localDataSource.saveWeatherForecast(any()) }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN retrieveWeatherResponseJson() is called THEN getWeatherForecast() is called from the localdatasource`() {
        runTest {
            coEvery { localDataSource.getWeatherForecast() } returns flow {
                emit(listOf(weatherEntity1, weatherEntity2))
            }
            weatherListRepository.retrieveWeatherResponseJson()
            coVerify { localDataSource.getWeatherForecast() }
        }
    }

    /**
     * Testing RemoteDataSource
     */
    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN getGeocodingResponseJson() is called THEN getGeocodingResponseFromApi() is called from the remotedatasource`() {
        runTest {
            coEvery { remoteDataSource.getGeocodingResponseFromApi(any()) } returns "response"
            weatherListRepository.getGeocodingResponseJson(ZIPCODE)
            coVerify { remoteDataSource.getGeocodingResponseFromApi(any()) }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN getWeatherResponseJson() is called THEN getWeatherForecastFromApi() is called from the remotedatasource`() {
        runTest {
            coEvery { remoteDataSource.getWeatherForecastFromApi(any(), any()) } returns "response"
            weatherListRepository.getWeatherResponseJson(LAT, LON)
            coVerify { remoteDataSource.getWeatherForecastFromApi(any(), any()) }
        }
    }


}