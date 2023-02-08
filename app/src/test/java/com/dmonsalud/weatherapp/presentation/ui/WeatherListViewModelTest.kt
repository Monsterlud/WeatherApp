package com.dmonsalud.weatherapp.presentation.ui

import android.net.ConnectivityManager
import com.dmonsalud.weatherapp.data.remote.datasource.NetworkUtils
import com.dmonsalud.weatherapp.data.repository.WeatherListRepositoryImpl
import com.dmonsalud.weatherapp.model.FiveDayWeatherResult
import com.dmonsalud.weatherapp.model.OpenWeatherApiResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test


class WeatherListViewModelTest {
    val networkUtils = mockk<NetworkUtils>()
    val connectivityManager = mockk<ConnectivityManager>()
    val openWeatherApiResponses = mockk<List<OpenWeatherApiResponse>>()
//    val weatherListViewModel = mockk<WeatherListViewModel>()
    val weatherListRepository = mockk<WeatherListRepositoryImpl>()
    val weatherListViewModel = WeatherListViewModel(weatherListRepository, networkUtils)

    val ZIPCODE = 80302

    @ExperimentalCoroutinesApi
    @Test
    fun `Given getFiveDayWeatherResponse() is called Then getGeocodingResponseFromZipCode() and getOpenWeatherResponse() are called`() {
        runTest {
            coEvery { networkUtils.hasInternetConnection(any()) } returns true
            coEvery { weatherListViewModel.getFiveDayWeatherForecast(any(), any()) } returns
                    FiveDayWeatherResult(openWeatherApiResponses)
            coEvery { weatherListViewModel.getGeocodingResponseFromZipCode(any()) } returns ""
            coEvery { weatherListViewModel.getOpenWeatherResponse(any(), any()) } returns ""
            coEvery { weatherListRepository.retrieveWeatherResponseJsonFromSharedPrefs() } returns ""
            weatherListViewModel.getFiveDayWeatherForecast(ZIPCODE, connectivityManager)

            coVerify {
                weatherListViewModel.getGeocodingResponseFromZipCode(any())
                weatherListViewModel.getOpenWeatherResponse(any(), any())
            }
        }
    }

    @Test
    fun `Given getGeocodingResponseFromZipCode() is called Then getGeocodingResponseJson() is called`() {
        runTest {
            coEvery { weatherListRepository.getGeocodingResponseJson(any()) } returns ""
            coEvery { weatherListViewModel.getGeocodingResponseFromZipCode(any()) } returns ""
            coEvery { weatherListRepository.retrieveWeatherResponseJsonFromSharedPrefs() } returns ""
            weatherListViewModel.getGeocodingResponseFromZipCode(ZIPCODE)

            coVerify { weatherListRepository.getGeocodingResponseJson(any()) }
        }
    }
}

