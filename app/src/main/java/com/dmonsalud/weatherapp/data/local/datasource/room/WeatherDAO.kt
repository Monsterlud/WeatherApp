package com.dmonsalud.weatherapp.data.local.datasource.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface WeatherDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addWeatherResponseToRoom(response: List<WeatherEntity>)

    @Query("SELECT * FROM weather_table")
    fun getWeatherResponseFromRoom() : List<WeatherEntity>
}