package com.dmonsalud.weatherapp.data.repository

import com.dmonsalud.weatherapp.data.LocalDataSource

class LocalDataSourceFake : LocalDataSource {
    val KEY = "test_key"
    val fakeSharedPreferencesMap = mutableMapOf<String, String>()

    override suspend fun saveWeatherForecast(value: String?) {
        value?.let {
            fakeSharedPreferencesMap.put(KEY, value)
        }
    }

    override suspend fun getWeatherForecast(): String? {
        return fakeSharedPreferencesMap.get(KEY)
    }
}