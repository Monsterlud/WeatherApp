package com.dmonsalud.weatherapp.model

object Constants {

    const val WEATHER_PREFERENCES = "weatherPreferences"
    const val FIVE_DAY_WEATHER_RESULT = "five_day_weather_result"

    private const val GEO_BASE_URL = "http://api.openweathermap.org"
    const val GEO_ZIP_ENDPOINT = "$GEO_BASE_URL/geo/1.0/"

    private const val WEATHER_BASE_URL = "https://api.openweathermap.org"
    const val WEATHER_FIVE_DAY_ENDPOINT = "$WEATHER_BASE_URL/data/2.5/"

    const val GEOAPIKEY = "6ac4a867247e4553cb55984a2afce83e"
    const val WEATHERAPIKEY = "c55cf80588aaf17941120bfbc7e366e8"
}