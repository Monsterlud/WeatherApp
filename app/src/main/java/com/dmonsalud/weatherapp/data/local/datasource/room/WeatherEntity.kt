package com.dmonsalud.weatherapp.data.local.datasource.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val dateTime: String,
    val temperature: Double,
    val humidity: Int,
    val weatherDescription: String
)
