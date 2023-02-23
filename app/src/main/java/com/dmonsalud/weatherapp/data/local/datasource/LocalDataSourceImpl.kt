package com.dmonsalud.weatherapp.data.local.datasource

import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherDAO
import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherEntity
import com.dmonsalud.weatherapp.data.remote.datasource.utils.EntityMappers
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
        if (value != null) {
            val weatherResponseList =
                gson.fromJson(value, FiveDayWeatherResponseFromApi::class.java).list
            for (apiResponse in weatherResponseList) {
                val item = mapper.mapFromDtoToEntity(apiResponse)
                weatherDAO.addWeatherResponseToRoom(item)
            }
        } else throw Exception("Invalid Json String")
    }

    override fun getWeatherForecast(): Flow<List<WeatherEntity>> {
        return weatherDAO.getWeatherResponseFromRoom()
    }
}

