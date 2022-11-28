package com.dmonsalud.weatherapp.ui

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmonsalud.weatherapp.data.network.datasource.FiveDayWeatherResult
import com.dmonsalud.weatherapp.data.network.datasource.HttpRequest
import com.dmonsalud.weatherapp.data.network.datasource.NetworkStatusChecker
import com.dmonsalud.weatherapp.databinding.FragmentListWeatherBinding
import com.google.gson.Gson

class WeatherListFragment : Fragment() {

    private lateinit var binding: FragmentListWeatherBinding
    private var sharedPreferences: SharedPreferences? = null
    private lateinit var weatherJsonStringHolder: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "WeatherApp Forecast"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListWeatherBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvWeatherList
        recyclerView.layoutManager = LinearLayoutManager(activity)

        getFiveDayWeatherForecast()
    }

    private fun getFiveDayWeatherForecast() {
        val connectivityManager =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkStatusChecker = NetworkStatusChecker(connectivityManager)

        if (networkStatusChecker.hasInternetConnection()) {
            weatherJsonStringHolder = HttpRequest(ZIPCODE).execute().get()
            saveResponseInSharedPrefs()

            val fiveDayWeatherResult = Gson().fromJson(weatherJsonStringHolder, FiveDayWeatherResult::class.java)
            binding.rvWeatherList.adapter = WeatherListAdapter(fiveDayWeatherResult)
        } else {
            sharedPreferences?.let {
                val jsonStringFromPrefs = sharedPreferences?.getString("five_day_weather_result", "N/A")
                val fiveDayWeatherResultFromPrefs = Gson().fromJson(jsonStringFromPrefs, FiveDayWeatherResult::class.java)
                binding.rvWeatherList.adapter = WeatherListAdapter(fiveDayWeatherResultFromPrefs)
            } ?: run {
                showNetworkAlertDialog()
            }
        }
    }

    private fun showNetworkAlertDialog() {
        AlertDialog.Builder(activity).setTitle("No Internet Connection")
            .setMessage("Please check your internet connection and try again")
            .setPositiveButton(android.R.string.ok) { _, _ -> }
            .setIcon(android.R.drawable.ic_dialog_alert).show()
    }

    private fun saveResponseInSharedPrefs() {
        sharedPreferences = activity?.getSharedPreferences("weatherPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString("five_day_weather_result", weatherJsonStringHolder)
        editor?.apply()
    }

    companion object {
        const val ZIPCODE = 80302
    }
}
