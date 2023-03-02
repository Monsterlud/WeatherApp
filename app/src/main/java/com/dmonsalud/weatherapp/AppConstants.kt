package com.dmonsalud.weatherapp

object AppConstants {

    const val WEATHER_PREFERENCES = "weatherPreferences"
    const val FIVE_DAY_WEATHER_RESULT = "five_day_weather_result"

    const val GEO_BASE_URL = "https://api.openweathermap.org/"
    const val GEO_ZIP_ENDPOINT = "geo/1.0/zip"

    const val WEATHER_BASE_URL = "https://api.openweathermap.org/"
    const val WEATHER_FIVE_DAY_ENDPOINT = "data/2.5/forecast"



    const val TIMEOUT = 10_000

    const val ZIP_REGEX = "^[0-9]{5}(?:-[0-9]{4})?$"
}