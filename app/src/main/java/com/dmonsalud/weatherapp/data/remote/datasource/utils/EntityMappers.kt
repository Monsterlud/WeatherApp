package com.dmonsalud.weatherapp.data.remote.datasource.utils

import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherEntity
import com.dmonsalud.weatherapp.utils.OpenWeatherApiResponse

class EntityMappers : ObjectMappers<OpenWeatherApiResponse, WeatherEntity> {

    override fun mapFromDtoToEntity(dto: OpenWeatherApiResponse): WeatherEntity {
        return WeatherEntity(
            dt_txt = dto.dt_txt,
            temp = dto.main.temp,
            humidity = dto.main.humidity,
            description = dto.weather.first().description
        )
    }
}