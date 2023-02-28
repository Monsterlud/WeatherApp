package com.dmonsalud.weatherapp.presentation.ui

import android.net.ConnectivityManager
import com.dmonsalud.weatherapp.data.local.datasource.room.FiveDayWeatherResult
import com.dmonsalud.weatherapp.data.remote.datasource.utils.NetworkUtils
import com.dmonsalud.weatherapp.data.repository.WeatherListRepositoryImpl
import com.dmonsalud.weatherapp.mocks.geoResponse
import com.dmonsalud.weatherapp.mocks.weatherResponse
import com.dmonsalud.weatherapp.rules.MainDispatcherRule
import com.google.gson.Gson
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WeatherListViewModelTest {

    val networkUtils = mockk<NetworkUtils>()
    val connectivityManager = mockk<ConnectivityManager>()
    val gson = mockk<Gson>()
    val weatherListRepository = mockk<WeatherListRepositoryImpl>(relaxed = true)
    val weatherListViewModel = WeatherListViewModel(weatherListRepository, networkUtils, gson)

    val ZIPCODE = "80302"

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher(TestCoroutineScheduler())

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

//    @ExperimentalCoroutinesApi
//    @Test
//    fun `GIVEN saveFiveDayWeatherForecast() is called THEN getGeocodingResponseJson() is called from repository`() {
//        runTest(UnconfinedTestDispatcher()) {
//
//            every { networkUtils.hasInternetConnection(connectivityManager) } returns true
//            coEvery { weatherListRepository.getGeocodingResponseJson(any()) } returns geoResponse
//            coEvery {
//                weatherListRepository.getWeatherResponseJson(
//                    any(),
//                    any()
//                )
//            } returns weatherResponse
//            coEvery { weatherListRepository.cacheWeatherResponseJson(any()) } returns Unit
//
//            weatherListViewModel.saveFiveDayWeatherForecast(ZIPCODE, connectivityManager)
//
//            coVerify {
//                weatherListRepository.getGeocodingResponseJson(any())
//            }
//        }
//    }

//    @ExperimentalCoroutinesApi
//    @Test
//    fun `GIVEN saveFiveDayWeatherForecast() is called THEN getWeatherResponseJson() is called from repository`() {
//        runTest {
//
//            every { networkUtils.hasInternetConnection(connectivityManager) } returns true
//            coEvery { weatherListRepository.getGeocodingResponseJson(any()) } returns geoResponse
//            coEvery {
//                weatherListRepository.getWeatherResponseJson(
//                    any(),
//                    any()
//                )
//            } returns weatherResponse
//            coEvery { weatherListRepository.cacheWeatherResponseJson(any()) } returns Unit
//
//            weatherListViewModel.saveFiveDayWeatherForecast(
//                ZIPCODE,
//                connectivityManager
//            )
//
//            coVerify {
//                weatherListRepository.getWeatherResponseJson(any(), any())
//            }
//        }
//    }

}

