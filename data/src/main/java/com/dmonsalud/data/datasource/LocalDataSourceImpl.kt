package com.dmonsalud.data.datasource

import com.dmonsalud.data.LocalDataSource
import com.dmonsalud.data.datasource.room.WeatherDAO
import com.dmonsalud.data.datasource.room.WeatherEntity
import com.dmonsalud.data.datasource.utils.EntityMappers
import com.dmonsalud.weatherapp.utils.FiveDayWeatherResponseFromApi
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    private val weatherDAO: WeatherDAO,
    private val gson: Gson,
    private val mapper: EntityMappers
) : LocalDataSource {

    override suspend fun saveWeatherForecast(value: String?) {
        weatherDAO.clearDatabase()
        if (!value.isNullOrEmpty()) {
                val weatherResponseList =
                    gson.fromJson(value, FiveDayWeatherResponseFromApi::class.java).list

                for (apiResponse in weatherResponseList) {
                    val item = mapper.mapFromDtoToEntity(apiResponse)
                    weatherDAO.addWeatherResponseToRoom(item)
                }
        } else throw IllegalArgumentException("Invalid Json String")
    }

    override fun getWeatherForecast(): Flow<List<WeatherEntity>> {
        return weatherDAO.getWeatherResponseFromRoom()
    }
}

