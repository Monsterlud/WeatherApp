package com.dmonsalud.weatherapp.presentation.ui

import android.net.ConnectivityManager
import com.dmonsalud.weatherapp.data.remote.datasource.utils.NetworkUtils
import com.dmonsalud.weatherapp.data.repository.WeatherListRepositoryImpl
import com.dmonsalud.weatherapp.utils.OpenWeatherApiResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test


class WeatherListViewModelTest {
    val networkUtils = NetworkUtils()
    val connectivityManager = mockk<ConnectivityManager>(relaxed = true)
    val openWeatherApiResponses = mockk<List<OpenWeatherApiResponse>>(relaxed = true)
    val weatherListRepository = mockk<WeatherListRepositoryImpl>(relaxed = true)
    val weatherListViewModel = WeatherListViewModel(weatherListRepository, networkUtils)

    val ZIPCODE = 80302

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN getGeocodingResponseFromZipCode() is called THEN getGeocodingResponseJson() is called in the repository`() {
        runTest {
            coEvery { weatherListViewModel.getGeocodingResponseFromZipCode(any()) } returns "response"
            coEvery { weatherListRepository.getGeocodingResponseJson(any()) } returns "response"
            coEvery { weatherListRepository.retrieveWeatherResponseJsonFromSharedPrefs() } returns "response"
            weatherListViewModel.getGeocodingResponseFromZipCode(ZIPCODE)
            coVerify { weatherListRepository.getGeocodingResponseJson(any()) }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN getOpenWeatherResponse() is called THEN getWeatherResponseJson() is called in the repository`() {
        runTest {
            coEvery { weatherListViewModel.getGeocodingResponseFromZipCode(any()) } returns "response"
            coEvery { weatherListRepository.getGeocodingResponseJson(any()) } returns "response"
            coEvery { weatherListRepository.retrieveWeatherResponseJsonFromSharedPrefs() } returns "response"
            weatherListViewModel.getGeocodingResponseFromZipCode(ZIPCODE)
            coVerify { weatherListRepository.getGeocodingResponseJson(any()) }
        }
    }
}

