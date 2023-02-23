package com.dmonsalud.weatherapp.presentation.ui

import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmonsalud.weatherapp.data.local.datasource.room.FiveDayWeatherResult
import com.dmonsalud.weatherapp.data.remote.datasource.utils.NetworkUtils
import com.dmonsalud.weatherapp.presentation.WeatherListRepository
import com.dmonsalud.weatherapp.utils.GeocodingApiResponse
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherListViewModel(
    private val weatherListRepository: WeatherListRepository,
    private val networkUtils: NetworkUtils,
    private val gson: Gson
) : ViewModel() {

    var location: String? = null

    /**
     * State Flow For UI to use
     */

    private val _weatherForecast = MutableStateFlow<FiveDayWeatherResult>(FiveDayWeatherResult(emptyList()))
    val weatherForecast = _weatherForecast.asStateFlow()

    init {
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
            val geoResult = getLatAndLonFromGeocodingApi(zipCode)
            getAndSaveWeatherResponseJsonFromApi(geoResult.lat, geoResult.lon)
            location = "${geoResult.name}, ${geoResult.country}"
        }
    }

    private suspend fun getLatAndLonFromGeocodingApi(zipCode: String) : GeocodingApiResponse {
        val geoJsonStringHolder = weatherListRepository.getGeocodingResponseJson(zipCode)
        return gson.fromJson(geoJsonStringHolder, GeocodingApiResponse::class.java)
    }

    private suspend fun getAndSaveWeatherResponseJsonFromApi(lat: Double?, lon: Double?) {
        val weatherJsonStringHolder =
            weatherListRepository.getWeatherResponseJson(lat.toString(), lon.toString())
        weatherListRepository.cacheWeatherResponseJson(weatherJsonStringHolder)
    }
}