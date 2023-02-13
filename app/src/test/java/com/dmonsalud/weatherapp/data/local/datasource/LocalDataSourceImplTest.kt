package com.dmonsalud.weatherapp.data.local.datasource

import com.dmonsalud.weatherapp.data.repository.LocalDataSourceFake
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class LocalDataSourceImplTest {

    private val localDataSourceFake = LocalDataSourceFake()
    private val testString = "The quick brown fox jumps over the lazy dog."

    @Test
    fun `GIVEN user saves a string as weather forecast THEN key-value pair is saved to SharedPreferences`() {
        localDataSourceFake.saveWeatherForecast(testString)
        val returnString = localDataSourceFake.getWeatherForecast()
        Assertions.assertEquals(testString, returnString)
    }
}

