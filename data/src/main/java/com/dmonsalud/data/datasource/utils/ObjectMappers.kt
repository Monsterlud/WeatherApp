package com.dmonsalud.data.datasource.utils

interface ObjectMappers <OpenWeatherApiResponse, WeatherEntity> {
    fun mapFromDtoToEntity(dto: OpenWeatherApiResponse) : WeatherEntity
}