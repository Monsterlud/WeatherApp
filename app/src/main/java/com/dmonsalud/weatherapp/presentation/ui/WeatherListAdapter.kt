package com.dmonsalud.weatherapp.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmonsalud.weatherapp.databinding.ItemListWeatherBinding
import com.dmonsalud.weatherapp.model.FiveDayWeatherResult

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
        holder.binding.dayTime.text = fiveDayWeatherResult.list[position].dt_txt
        holder.binding.temperature.text = fiveDayWeatherResult.list[position].main.temp.toString()
        holder.binding.wind.text = fiveDayWeatherResult.list[position].wind.speed.toString()
        holder.binding.weatherOutlook.text = fiveDayWeatherResult.list[position].weather.toString()
    }

    override fun getItemCount(): Int = fiveDayWeatherResult.list.size

    class WeatherItemViewHolder(val binding: ItemListWeatherBinding) :
        RecyclerView.ViewHolder(binding.root)
}
