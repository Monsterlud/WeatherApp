package com.dmonsalud.weatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmonsalud.weatherapp.data.network.datasource.FiveDayWeatherResult
import com.dmonsalud.weatherapp.databinding.ItemWeatherBinding

class WeatherListAdapter(private val fiveDayWeatherResult: FiveDayWeatherResult) :
    RecyclerView.Adapter<WeatherListAdapter.WeatherItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherItemViewHolder {
        val binding = ItemWeatherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeatherItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherItemViewHolder, position: Int) {
        holder.binding.dayTime.text = fiveDayWeatherResult.list[position].dt_txt
        holder.binding.temperature.text = fiveDayWeatherResult.list[position].main.temp.toString()
        holder.binding.wind.text = fiveDayWeatherResult.list[position].wind.speed.toString()
        holder.binding.weatherOutlook.text = fiveDayWeatherResult.list[position].weather.toString()
    }

    override fun getItemCount(): Int = fiveDayWeatherResult.list.size

    class WeatherItemViewHolder(val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root)
}
