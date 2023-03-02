package com.dmonsalud.weatherapp.utils

object Constants {

    const val WEATHER_PREFERENCES = "weatherPreferences"
    const val FIVE_DAY_WEATHER_RESULT = "five_day_weather_result"

    const val GEO_BASE_URL = "https://api.openweathermap.org/"
    const val GEO_ZIP_ENDPOINT = "geo/1.0/zip"

    const val WEATHER_BASE_URL = "https://api.openweathermap.org/"
    const val WEATHER_FIVE_DAY_ENDPOINT = "data/2.5/forecast"

    const val GEOAPIKEY = "6ac4a867247e4553cb55984a2afce83e"
    const val WEATHERAPIKEY = "c55cf80588aaf17941120bfbc7e366e8"

    const val TIMEOUT = 10_000

    const val ZIP_REGEX = "^[0-9]{5}(?:-[0-9]{4})?$"
}