package com.dmonsalud.weatherapp.data.local.datasource

import android.content.SharedPreferences
import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.model.Constants.FIVE_DAY_WEATHER_RESULT

class LocalDataSourceImpl(
    private val weatherPreferences: SharedPreferences
) : LocalDataSource {

    override fun saveWeatherForecast(value: String?) {
        return with(weatherPreferences.edit()) {
            putString(FIVE_DAY_WEATHER_RESULT, value)
            apply()
        }
    }

    override fun getWeatherForecast(): String? {
        return weatherPreferences.getString(FIVE_DAY_WEATHER_RESULT, "n/a")
    }
}
