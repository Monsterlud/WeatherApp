package com.dmonsalud.weatherapp.data.local.datasource

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class LocalDataSourceImplTest {

    /**
     * This test is to show how creating a complete test double of a class like
     * SharedPreferences can also be used to mock a test class
     */

    private val sharedPreferencesFake = SharedPreferencesFake()
    private val localDataSourceImpl = LocalDataSourceImpl(sharedPreferencesFake)
    private val testString = "test value"

    @Test
    fun `GIVEN user saves a string as weather forecast THEN key-value pair is saved to SharedPreferences`() {
        localDataSourceImpl.saveWeatherForecast(testString)
        val returnString = localDataSourceImpl.getWeatherForecast()
        Assertions.assertEquals(testString, returnString)
    }

    @Test
    fun `GIVEN user saves an empty string as weather forecast THEN key-value pair is not saved to SharedPreferences`() {
        localDataSourceImpl.saveWeatherForecast("")
        val returnString = localDataSourceImpl.getWeatherForecast()
        Assertions.assertNotEquals(testString, returnString)
    }

    @Test
    fun `GIVEN user saves an null value as weather forecast THEN key-value pair is not saved to SharedPreferences`() {
        localDataSourceImpl.saveWeatherForecast(null)
        val returnString = localDataSourceImpl.getWeatherForecast()
        Assertions.assertNotEquals(testString, returnString)
    }
}

