package com.dmonsalud.weatherapp.presentation.ui

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
import com.dmonsalud.weatherapp.data.remote.datasource.FiveDayWeatherResult
import com.dmonsalud.weatherapp.data.remote.datasource.NetworkUtils
import com.dmonsalud.weatherapp.data.remote.datasource.OpenWeatherApiHttpRequest
import com.dmonsalud.weatherapp.data.repository.WeatherListRepositoryImpl
import com.dmonsalud.weatherapp.databinding.FragmentListWeatherBinding
import com.dmonsalud.weatherapp.model.Constants.FIVE_DAY_WEATHER_RESULT
import com.dmonsalud.weatherapp.model.Constants.ZIPCODE
import com.google.gson.Gson

class WeatherListFragment() : Fragment() {

    private lateinit var binding: FragmentListWeatherBinding
    private var sharedPreferences: SharedPreferences? = null
    private lateinit var weatherJsonStringHolder: String
    val weatherListRepository = context?.let { WeatherListRepositoryImpl(it) }

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
        // Check to see if device has a network connection
        val connectivityManager =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        /**
         *  If the device has a network connection, make an HttpRequest to get the Json payload
         *  then save that payload to SharedPreferences
         */
        if (NetworkUtils(connectivityManager).hasInternetConnection()) {
            weatherJsonStringHolder = OpenWeatherApiHttpRequest(ZIPCODE).execute().get()
            weatherListRepository?.cacheWeatherResponseJson(FIVE_DAY_WEATHER_RESULT, weatherJsonStringHolder)

            /**
             * Translate Json to create a list of OpenWeatherApiResponse objects
             * then bind these with the WeatherListAdapter
             */
            val fiveDayWeatherResult =
                Gson().fromJson(weatherJsonStringHolder, FiveDayWeatherResult::class.java)
            binding.rvWeatherList.adapter = WeatherListAdapter(fiveDayWeatherResult)
        } else {
            // Alternatively, get the list of OpenWeatherApiResponse object from SharedPreferences
            sharedPreferences?.let {
                val jsonStringFromPrefs =
                    weatherListRepository?.retrieveWeatherResponseJson(FIVE_DAY_WEATHER_RESULT)
                val fiveDayWeatherResultFromPrefs =
                    Gson().fromJson(jsonStringFromPrefs, FiveDayWeatherResult::class.java)
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

    private fun saveResponseInSharedPrefs(key: String, value: String) {
        sharedPreferences =
            activity?.getSharedPreferences("weatherPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString(key, value)
        editor?.apply()
    }
}
