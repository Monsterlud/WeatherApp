package com.dmonsalud.weatherapp.data

interface LocalDataSource {

    fun saveWeatherPref(key: String, value: String)

    fun getWeatherPref(key: String): String?
}