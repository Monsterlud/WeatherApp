package com.dmonsalud.weatherapp.presentation.ui

import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel
import com.dmonsalud.weatherapp.data.remote.datasource.NetworkUtils
import com.dmonsalud.weatherapp.model.FiveDayWeatherResult
import com.dmonsalud.weatherapp.model.GeocodingApiResponse
import com.dmonsalud.weatherapp.presentation.WeatherListRepository
import com.google.gson.Gson

class WeatherListViewModel(
    private val weatherListRepository: WeatherListRepository,
    private val networkUtils: NetworkUtils
): ViewModel() {
    /**
     * Local Caching in SharedPreferences
     */

    val responseJsonFromSharedPrefs = weatherListRepository.retrieveWeatherResponseJsonFromSharedPrefs()

    fun saveWeatherResponseJsonToSharedPrefs(value: String?) {
        if (!value.isNullOrEmpty()) {
            return weatherListRepository.cacheWeatherResponseJsonToSharedPrefs(value)
        } else {
            throw Exception("Cannot save null value or empty string.")
        }
    }

    /**
     * Remote Network Calls
     */

    suspend fun getGeocodingResponseFromZipCode(zipCode: Int) {
        weatherListRepository.getGeocodingResponseJson(zipCode)
    }

    suspend fun getOpenWeatherResponse(lat: String, long: String) {
        weatherListRepository.getWeatherResponseJsonFromOpenWeatherApi(lat, long)
    }

    /**
     * Five Day Weather Forecast
     */

    suspend fun getFiveDayWeatherForecast(zipCode: Int, connectivityManager: ConnectivityManager): FiveDayWeatherResult {
        val gson = Gson()
        var weatherJsonStringHolder = ""
        if (networkUtils.hasInternetConnection(connectivityManager)) {
            val geoJsonStringHolder = weatherListRepository.getGeocodingResponseJson(zipCode)
            val geoResult = gson.fromJson(geoJsonStringHolder, GeocodingApiResponse::class.java)
            val lat = geoResult.lat
            val long = geoResult.lon

            weatherJsonStringHolder =
                weatherListRepository.getWeatherResponseJsonFromOpenWeatherApi(lat.toString(), long.toString())
                    .toString()

        }
        return gson.fromJson(weatherJsonStringHolder, FiveDayWeatherResult::class.java)
    }
}