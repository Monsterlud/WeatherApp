package com.dmonsalud.weatherapp.presentation.ui

import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel
import com.dmonsalud.weatherapp.data.local.datasource.room.FiveDayWeatherResult
import com.dmonsalud.weatherapp.data.remote.datasource.utils.NetworkUtils
import com.dmonsalud.weatherapp.presentation.WeatherListRepository
import com.dmonsalud.weatherapp.utils.GeocodingApiResponse
import com.google.gson.Gson

class WeatherListViewModel(
    private val weatherListRepository: WeatherListRepository,
    private val networkUtils: NetworkUtils
) : ViewModel() {

    /**
     * Five Day Weather Forecast
     */
    suspend fun getFiveDayWeatherForecast(
        zipCode: Int,
        connectivityManager: ConnectivityManager
    ): FiveDayWeatherResult {
        val gson = Gson()

        if (networkUtils.hasInternetConnection(connectivityManager)) {
            /**
             * Get Response Json from Geocoding API and convert it to a GeoCodingApiResponse object
             * THEN, extract the 'lat' and 'lon' from that object
              */

            val geoJsonStringHolder = weatherListRepository.getGeocodingResponseJson(zipCode)
            val geoResult = gson.fromJson(geoJsonStringHolder, GeocodingApiResponse::class.java)
            val lat = geoResult.lat
            val lon = geoResult.lon

            /**
             * Using the 'lat' and 'lon' from the previous API call,
             * Get Response Json from OpenWeather API
             * THEN use pass that Json String onto the Repository/LocalDataSource to convert into
             * WeatherEntity objects and save to Room Database
             */
            val weatherJsonStringHolder =
                weatherListRepository.getWeatherResponseJson(lat.toString(), lon.toString())
            weatherListRepository.cacheWeatherResponseJson(weatherJsonStringHolder)
        }
        return gson.fromJson(weatherListRepository.retrieveWeatherResponseJson(), FiveDayWeatherResult::class.java)
    }
}