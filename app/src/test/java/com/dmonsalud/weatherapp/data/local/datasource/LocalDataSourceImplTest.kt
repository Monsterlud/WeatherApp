package com.dmonsalud.weatherapp.data.local.datasource

import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherDAO
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class LocalDataSourceImplTest {

    val dao = mockk<WeatherDAO>()
    val localDataSource = LocalDataSourceImpl(dao)

    @Test
    fun `GIVEN user saves an empty string as weather forecast THEN an Exception is thrown`() {
        Assertions.assertThrows(Exception::class.java) {
            runBlocking {
                localDataSource.saveWeatherForecast("")
            }
        }
    }

    @Test
    fun `GIVEN user saves an null value as weather forecast THEN an Exception is thrown`() {
        Assertions.assertThrows(Exception::class.java) {
            runBlocking {
                localDataSource.saveWeatherForecast(null)
            }
        }
    }
}

