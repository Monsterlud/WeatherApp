package com.dmonsalud.ui.ui

import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmonsalud.data.WeatherListRepository
import com.dmonsalud.data.datasource.room.FiveDayWeatherResult
import com.dmonsalud.data.datasource.utils.NetworkUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherListViewModel(
    private val weatherListRepository: WeatherListRepository,
    private val networkUtils: NetworkUtils,
) : ViewModel() {

    var location: String? = null

    /**
     * State Flow For UI to use
     */

    private val _weatherForecast = MutableStateFlow<FiveDayWeatherResult>(FiveDayWeatherResult(emptyList()))
    val weatherForecast = _weatherForecast.asStateFlow()

    fun initialize() {
        viewModelScope.launch {
            weatherListRepository.retrieveWeatherResponseJson().collect { weatherForecast ->
                _weatherForecast.value = FiveDayWeatherResult(weatherForecast)
            }
        }
    }

    /**
     * Save Five Day Weather Forecast
     */

    suspend fun saveFiveDayWeatherForecast(
        zipCode: String,
        connectivityManager: ConnectivityManager
    ) {
        if (networkUtils.hasInternetConnection(connectivityManager)) {
            location = weatherListRepository.getAndSaveFiveDayWeatherForecast(zipCode)
        }
    }
}