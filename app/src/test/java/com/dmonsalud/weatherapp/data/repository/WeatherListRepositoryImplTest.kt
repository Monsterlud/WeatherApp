package com.dmonsalud.weatherapp.data.repository

import com.dmonsalud.weatherapp.data.remote.datasource.RemoteDataSourceImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class WeatherListRepositoryImplTest {
    private val localDataSourceFake = LocalDataSourceFake()
    private val testString = "The quick brown fox jumps over the lazy dog."
    private val remoteDataSource = mockk<RemoteDataSourceImpl>()
    private val weatherListRepository = WeatherListRepositoryImpl(localDataSourceFake, remoteDataSource)
    val ZIPCODE = 80304
    val LAT = "40"
    val LON = "-100"

    @Test
    fun `GIVEN user saves a string as weather forecast THEN key-value pair is saved to SharedPreferences`() {
        weatherListRepository.cacheWeatherResponseJsonToSharedPrefs(testString)
        val returnString = weatherListRepository.retrieveWeatherResponseJsonFromSharedPrefs()
        Assertions.assertEquals(testString, returnString)
    }

    @Test
    fun `GIVEN user saves an empty string as weather forecast THEN an Exception is thrown`() {
        Assertions.assertThrows(Exception::class.java) {
            weatherListRepository.cacheWeatherResponseJsonToSharedPrefs("")
        }
    }

    @Test
    fun `GIVEN user saves an null value as weather forecast THEN an Exception is thrown`() {
        Assertions.assertThrows(Exception::class.java) {
            weatherListRepository.cacheWeatherResponseJsonToSharedPrefs(null)
        }
    }

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