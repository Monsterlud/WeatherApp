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

    val responseJsonFromSharedPrefs = weatherListRepository.retrieveWeatherResponseJsonFromSharedPrefs()

    suspend fun getGeocodingResponseFromZipCode(zipCode: Int): String? {
        return weatherListRepository.getGeocodingResponseJson(zipCode)
    }

    suspend fun getOpenWeatherResponse(lat: String, long: String): String? {
        return weatherListRepository.getWeatherResponseJson(lat, long)
    }

    /**
     * Five Day Weather Forecast
     */

    suspend fun getFiveDayWeatherForecast(zipCode: Int, connectivityManager: ConnectivityManager): FiveDayWeatherResult {
        val gson = Gson()
        var weatherJsonStringHolder = ""
        var fiveDayWeatherResult: FiveDayWeatherResult
        if (networkUtils.hasInternetConnection(connectivityManager)) {
            val geoJsonStringHolder = getGeocodingResponseFromZipCode(zipCode)
            val geoResult = gson.fromJson(geoJsonStringHolder, GeocodingApiResponse::class.java)
            val lat = geoResult.lat
            val long = geoResult.lon

            weatherJsonStringHolder =
                getOpenWeatherResponse(lat.toString(), long.toString())
                    .toString()
            fiveDayWeatherResult = gson.fromJson(weatherJsonStringHolder, FiveDayWeatherResult::class.java)
        } else {
            fiveDayWeatherResult = gson.fromJson(responseJsonFromSharedPrefs, FiveDayWeatherResult::class.java)
        }
        return fiveDayWeatherResult
    }
}