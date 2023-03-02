package com.dmonsalud.weatherapp.presentation.ui

import com.dmonsalud.ui.ui.WeatherListViewModel
import com.dmonsalud.data.datasource.room.WeatherEntity
import com.dmonsalud.data.datasource.utils.NetworkUtils
import com.dmonsalud.data.repository.WeatherListRepositoryImpl
import com.dmonsalud.weatherapp.rules.MainDispatcherRule
import com.google.gson.Gson
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.jupiter.api.Test

import kotlin.test.assertEquals

class WeatherListViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    val weatherListRepository = mockk<WeatherListRepositoryImpl>()
    val networkUtils = mockk<NetworkUtils>()
    val gson = mockk<Gson>()

    val weatherEntity1 = WeatherEntity(
        0,
        "Rick",
        0.0,
        0,
        "Freezing"
    )

    val weatherEntity2 = WeatherEntity(
        1,
        "Morty",
        25.0,
        25,
        "Cold"
    )

    val weatherEntity3 = WeatherEntity(
        2,
        "Summer",
        75.0,
        75,
        "Warm"
    )

    val weatherEntity4 = WeatherEntity(
        3,
        "Beth",
        100.0,
        100,
        "Hot"
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testStateFlowFromRepository() {
        runTest {
            coEvery {
                weatherListRepository.retrieveWeatherResponseJson()
            } returns flow {
                emit(
                    listOf(
                        weatherEntity1,
                        weatherEntity2
                    )
                )
                delay(100)
                emit(
                    listOf(
                        weatherEntity3,
                        weatherEntity4,
                    )
                )
            }

            val weatherListViewModel = WeatherListViewModel(
                weatherListRepository,
                networkUtils,
                gson,
            )

            launch(Dispatchers.Main) { weatherListViewModel.initialize() }
            advanceUntilIdle()
            assertEquals(listOf( weatherEntity1, weatherEntity2), weatherListViewModel.weatherForecast.first().list)
        }
    }
}

