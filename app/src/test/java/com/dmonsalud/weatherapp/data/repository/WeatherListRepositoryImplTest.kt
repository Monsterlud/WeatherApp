package com.dmonsalud.weatherapp.data.repository

import com.dmonsalud.weatherapp.data.remote.datasource.RemoteDataSourceImpl
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class WeatherListRepositoryImplTest {
    private val localDataSourceFake = LocalDataSourceFake()
    private val testString = "The quick brown fox jumps over the lazy dog."
    private val remoteDataSource = mockk<RemoteDataSourceImpl>()
    private val weatherListRepository = WeatherListRepositoryImpl(localDataSourceFake, remoteDataSource)

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
}