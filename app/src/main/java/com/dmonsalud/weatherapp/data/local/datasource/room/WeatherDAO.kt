package com.dmonsalud.weatherapp.data.local.datasource.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface WeatherDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWeatherResponseToRoom(entity: WeatherEntity)

    @Query("SELECT * FROM weather_table ORDER BY id ASC")
    suspend fun getWeatherResponseFromRoom() : List<WeatherEntity>

    @Query("DELETE FROM weather_table")
    suspend fun clearDatabase()
}