package com.dmonsalud.weatherapp.data.local.datasource

import com.dmonsalud.data.datasource.LocalDataSourceImpl
import com.dmonsalud.data.datasource.room.WeatherDAO
import com.dmonsalud.data.datasource.room.WeatherEntity
import com.dmonsalud.data.datasource.utils.EntityMappers
import com.google.gson.Gson
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
internal class LocalDataSourceImplTest {

    val dao = mockk<WeatherDAO>()
    val gson = mockk<Gson>()
    val entityMappers = mockk<EntityMappers>()
    val localDataSource = LocalDataSourceImpl(dao, gson, entityMappers)

    val invalidJson: String = "{\"rick, \"morty\"}"

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

    // Test that a malformed Json string throws an exception
    @Test
    fun `GIVEN user saves an invalid json value as weather forecast THEN an Exception is thrown`() {
        Assertions.assertThrows(Exception::class.java) {
            runBlocking {
                localDataSource.saveWeatherForecast(invalidJson)
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testFlowFromRoom() {
        runTest {
            coEvery { dao.getWeatherResponseFromRoom() } returns flowOf(
                listOf(
                    weatherEntity1,
                    weatherEntity2
                )
            )
            val weatherList = dao.getWeatherResponseFromRoom()
            assertEquals(1, weatherList.count())
            val humidity1 = weatherList.first()[0].humidity
            assertEquals(100, humidity1)
            val temp2 = weatherList.first()[1].temp
            assertEquals(50.0, temp2)
            assertEquals(2, weatherList.first().size)
        }
    }
}
