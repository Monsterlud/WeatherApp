package com.dmonsalud.data.datasource.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "dt_txt")
    var dt_txt: String = "",
    @ColumnInfo(name = "temp")
    var temp: Double = 0.0,
    @ColumnInfo(name = "humidity")
    var humidity: Int = 100,
    @ColumnInfo(name = "description")
    var description: String = ""
)

data class FiveDayWeatherResult(
    var list: List<WeatherEntity>
)
