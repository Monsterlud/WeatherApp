package com.dmonsalud.weatherapp.presentation.ui

import android.net.ConnectivityManager
import com.dmonsalud.weatherapp.data.local.datasource.room.FiveDayWeatherResult
import com.dmonsalud.weatherapp.data.remote.datasource.utils.NetworkUtils
import com.dmonsalud.weatherapp.data.repository.WeatherListRepositoryImpl
import com.dmonsalud.weatherapp.mocks.geoResponse
import com.dmonsalud.weatherapp.mocks.weatherResponse
import com.dmonsalud.weatherapp.rules.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.jupiter.api.Test

class WeatherListViewModelTest {
    val networkUtils = mockk<NetworkUtils>()
    val connectivityManager = mockk<ConnectivityManager>()
    val weatherListRepository = mockk<WeatherListRepositoryImpl>(relaxed = true)
    val weatherListViewModel = WeatherListViewModel(weatherListRepository, networkUtils)
    val fiveDayWeatherResult = mockk<FiveDayWeatherResult>()

    val ZIPCODE = "80302"

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineTestRule = MainDispatcherRule()

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN getFiveDayWeatherForecast() is called THEN getGeocodingResponseJson() is called from repository`() {
        runTest {
            every { networkUtils.hasInternetConnection(connectivityManager) } returns true
            coEvery { weatherListRepository.getGeocodingResponseJson(any()) } returns geoResponse
            coEvery { weatherListRepository.getWeatherResponseJson(any(), any()) } returns weatherResponse
            coEvery { weatherListRepository.retrieveWeatherResponseJson() } returns weatherResponse

            weatherListViewModel.getFiveDayWeatherForecast(ZIPCODE, connectivityManager)

            coVerify {
                weatherListRepository.getGeocodingResponseJson(any())
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN getFiveDayWeatherForecast() is called THEN getWeatherResponseJson() is called from repository`() {
        runTest {
            every { networkUtils.hasInternetConnection(connectivityManager) } returns true
            coEvery { weatherListRepository.getGeocodingResponseJson(any()) } returns geoResponse
            coEvery { weatherListRepository.getWeatherResponseJson(any(), any()) } returns weatherResponse
            coEvery { weatherListRepository.retrieveWeatherResponseJson() } returns weatherResponse

            weatherListViewModel.getFiveDayWeatherForecast(ZIPCODE, connectivityManager)

            coVerify {
                weatherListRepository.getWeatherResponseJson(any(), any())
            }
        }
    }
}

