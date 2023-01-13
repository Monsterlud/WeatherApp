package com.dmonsalud.weatherapp.data.repository

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class WeatherListRepositoryImplTest {

    private val localDataSourceFake = LocalDataSourceFake()
    private val weatherListRepositoryImpl = WeatherListRepositoryImpl(localDataSourceFake)
    private val testString = "test value"

    @Test
    fun `GIVEN user saves a string as weather forecast THEN key-value pair is saved to SharedPreferences`() {
        weatherListRepositoryImpl.cacheWeatherResponseJson(testString)
        val returnString = weatherListRepositoryImpl.retrieveWeatherResponseJson()
        Assertions.assertEquals(testString, returnString)
    }

    @Test
    fun `GIVEN user saves an empty string as weather forecast THEN key-value pair is not saved to SharedPreferences`() {
        weatherListRepositoryImpl.cacheWeatherResponseJson("")
        val returnString = weatherListRepositoryImpl.retrieveWeatherResponseJson()
        Assertions.assertNotEquals(testString, returnString)
    }

    @Test
    fun `GIVEN user saves an null value as weather forecast THEN key-value pair is not saved to SharedPreferences`() {
        weatherListRepositoryImpl.cacheWeatherResponseJson(null)
        val returnString = weatherListRepositoryImpl.retrieveWeatherResponseJson()
        Assertions.assertNotEquals(testString, returnString)
    }
}