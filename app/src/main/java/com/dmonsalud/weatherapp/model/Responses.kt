package com.dmonsalud.weatherapp.model

import kotlinx.serialization.Serializable

/**
 * Geocoding Api Response
 */

@Serializable
data class GeocodingApiResponse(
    var country: String,
    var lat: Double,
    var lon: Double,
    var name: String,
    var zip: String
)

/**
 * Open Weather Api Response
 */

@Serializable
data class FiveDayWeatherResult(
    val list: List<OpenWeatherApiResponse>
)

@Serializable
data class OpenWeatherApiResponse(
    var clouds: Clouds,
    var dt: Int,
    var dt_txt: String,
    var main: Main,
    var pop: Double,
    var rain: Rain,
    var sys: Sys,
    var visibility: Int,
    var weather: List<Weather>,
    var wind: Wind
)

@Serializable
data class Clouds(
    var all: Int
)

@Serializable
data class Main(
    var feels_like: Double,
    var grnd_level: Int,
    var humidity: Int,
    var pressure: Int,
    var sea_level: Int,
    var temp: Double,
    var temp_kf: Double,
    var temp_max: Double,
    var temp_min: Double
)

@Serializable
data class Rain(
    var `3h`: Double
)

@Serializable
data class Sys(
    var pod: String
)

@Serializable
data class Weather(
    var description: String,
    var icon: String,
    var id: Int,
    var main: String
)

@Serializable
data class Wind(
    var deg: Int,
    var gust: Double,
    var speed: Double
)
