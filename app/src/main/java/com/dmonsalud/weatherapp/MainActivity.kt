package com.dmonsalud.weatherapp

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmonsalud.weatherapp.data.network.datasource.FiveDayWeatherResult
import com.dmonsalud.weatherapp.data.network.datasource.HttpRequest
import com.dmonsalud.weatherapp.data.network.datasource.NetworkStatusChecker
import com.dmonsalud.weatherapp.databinding.ActivityMainBinding
import com.dmonsalud.weatherapp.ui.WeatherListAdapter
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weatherList.layoutManager = LinearLayoutManager(this)

        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkStatusChecker = NetworkStatusChecker(connectivityManager)

        if (networkStatusChecker.hasInternetConnection()) {
            val weatherJsonStringHolder = HttpRequest(ZIPCODE).execute().get()
            val fiveDayWeatherResult = Gson().fromJson(weatherJsonStringHolder, FiveDayWeatherResult::class.java)
            binding.weatherList.adapter = fiveDayWeatherResult?.let { WeatherListAdapter(it) }
        } else {
            AlertDialog.Builder(this).setTitle("No Internet Connection")
                .setMessage("Please check your internet connection and try again")
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }
    }

    companion object {
        const val ZIPCODE = 80302
        var fiveDayWeatherResult: FiveDayWeatherResult? = null
    }
}
