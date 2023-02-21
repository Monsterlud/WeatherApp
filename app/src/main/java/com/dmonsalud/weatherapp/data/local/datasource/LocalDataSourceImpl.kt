package com.dmonsalud.weatherapp.data.local.datasource

import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.data.local.datasource.room.FiveDayWeatherResult
import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherDAO
import com.dmonsalud.weatherapp.data.remote.datasource.utils.EntityMappers
import com.dmonsalud.weatherapp.utils.FiveDayWeatherResponseFromApi
import com.google.gson.Gson
import kotlinx.serialization.SerializationException

class LocalDataSourceImpl(
    private val weatherDAO: WeatherDAO,
    private val gson: Gson,
    private val mapper: EntityMappers
) : LocalDataSource {

    override suspend fun saveWeatherForecast(value: String?) {
        weatherDAO.clearDatabase()
        if (!value.isNullOrEmpty()) {
            try {
                val weatherResponseList =
                    gson.fromJson(value, FiveDayWeatherResponseFromApi::class.java).list

                for (apiResponse in weatherResponseList) {
                    val item = mapper.mapFromDtoToEntity(apiResponse)
                    weatherDAO.addWeatherResponseToRoom(item)
                }
            } catch (e: Exception) {
                throw SerializationException(e)
            }
        } else throw IllegalArgumentException("Invalid Json String")
    }

    override suspend fun getWeatherForecast(): String? {
        val weatherList = weatherDAO.getWeatherResponseFromRoom()
        val fiveDayWeatherResult = FiveDayWeatherResult(weatherList)
        return gson.toJson(fiveDayWeatherResult)
    }
}
