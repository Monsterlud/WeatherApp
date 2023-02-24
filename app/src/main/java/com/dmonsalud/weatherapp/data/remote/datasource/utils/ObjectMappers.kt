package com.dmonsalud.weatherapp.data.remote.datasource.utils

interface ObjectMappers <OpenWeatherApiResponse, WeatherEntity> {
    fun mapFromDtoToEntity(dto: OpenWeatherApiResponse) : WeatherEntity
}