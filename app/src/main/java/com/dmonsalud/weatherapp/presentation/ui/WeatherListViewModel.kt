package com.dmonsalud.weatherapp.presentation.ui

import androidx.lifecycle.ViewModel
import com.dmonsalud.weatherapp.presentation.WeatherListRepository

class WeatherListViewModel(
    private val weatherListRepository: WeatherListRepository
): ViewModel() {

    val responseJson = weatherListRepository.retrieveWeatherResponseJson()

    fun saveWeatherResponseJson(value: String?) {
        if (!value.isNullOrEmpty()) {
            return weatherListRepository.cacheWeatherResponseJson(value)
        } else {
            throw Exception("Cannot save null value or empty string.")
        }
    }
}