package com.dmonsalud.weatherapp.presentation.ui

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmonsalud.weatherapp.R
import com.dmonsalud.weatherapp.data.remote.datasource.NetworkUtils
import com.dmonsalud.weatherapp.data.remote.datasource.OpenWeatherApiHttpRequest
import com.dmonsalud.weatherapp.databinding.FragmentListWeatherBinding
import com.dmonsalud.weatherapp.model.FiveDayWeatherResult
import com.google.gson.Gson
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherListFragment() : Fragment() {

    private lateinit var binding: FragmentListWeatherBinding

    private val sharedPreferences by inject<SharedPreferences>()
    private val weatherListViewModel by viewModel<WeatherListViewModel>()

    private lateinit var weatherJsonStringHolder: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = getString(R.string.weatherapp_forecast)
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

        binding.zipCodeSubmitButton.setOnClickListener {
            getFiveDayWeatherForecast(binding.etZipCode.text.toString().toInt())
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvWeatherList
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    private fun getFiveDayWeatherForecast(zipCode: Int) {
        // Check to see if device has a network connection
        val connectivityManager =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        /**
         *  If the device has a network connection, make an HttpRequest to get the Json payload
         *  then save that payload to SharedPreferences
         */
        if (NetworkUtils().hasInternetConnection(connectivityManager)) {
            weatherJsonStringHolder = OpenWeatherApiHttpRequest(zipCode).execute().get()
            weatherListViewModel.saveWeatherResponseJson(weatherJsonStringHolder)

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
                val jsonStringFromLocalStorage =
                    weatherListViewModel?.responseJson
                val fiveDayWeatherResultFromPrefs =
                    Gson().fromJson(jsonStringFromLocalStorage, FiveDayWeatherResult::class.java)
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
}
