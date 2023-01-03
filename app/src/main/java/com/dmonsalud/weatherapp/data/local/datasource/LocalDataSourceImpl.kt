package com.dmonsalud.weatherapp.data.local.datasource

import android.content.Context
import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.model.Constants.WEATHER_PREFERENCES

class LocalDataSourceImpl(
    context: Context
) : LocalDataSource {

    val weatherPreferences = context.getSharedPreferences(WEATHER_PREFERENCES, Context.MODE_PRIVATE)


    override fun saveWeatherForecast(key: String, value: String) {
        with(weatherPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getWeatherForecast(key: String): String? {
        return weatherPreferences.getString(key, "n/a")
    }
}