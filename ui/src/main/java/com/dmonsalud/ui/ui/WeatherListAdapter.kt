package com.dmonsalud.weatherapp.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmonsalud.weatherapp.data.local.datasource.room.FiveDayWeatherResult
import com.dmonsalud.weatherapp.databinding.ItemListWeatherBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class WeatherListAdapter(private val fiveDayWeatherResult: FiveDayWeatherResult) :
    RecyclerView.Adapter<WeatherListAdapter.WeatherItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherItemViewHolder {
        val binding = ItemListWeatherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeatherItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherItemViewHolder, position: Int) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val dateTime = LocalDateTime.parse(fiveDayWeatherResult.list[position].dt_txt, formatter)
        val ldtFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        val formattedDate = dateTime.format(ldtFormatter)

        val kToF = ((1.8 * (fiveDayWeatherResult.list[position].temp-273)) + 32).toInt()
        val temp = "Temperature: $kToF F"

        val humidity = "Humidity: ${fiveDayWeatherResult.list[position].humidity}%"

        val weatherDescription = "Forecast: ${fiveDayWeatherResult.list[position].description}"

        holder.binding.dayTime.text = formattedDate.toString()
        holder.binding.temperature.text = temp
        holder.binding.humidity.text = humidity
        holder.binding.weatherDescription.text = weatherDescription
    }

    override fun getItemCount(): Int = fiveDayWeatherResult.list.size

    class WeatherItemViewHolder(val binding: ItemListWeatherBinding) :
        RecyclerView.ViewHolder(binding.root)
}
