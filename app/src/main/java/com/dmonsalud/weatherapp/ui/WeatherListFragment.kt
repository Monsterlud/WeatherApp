package com.dmonsalud.weatherapp.ui

import android.app.AlertDialog
import android.content.Context
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

        val connectivityManager =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkStatusChecker = NetworkStatusChecker(connectivityManager)

        if (networkStatusChecker.hasInternetConnection()) {
            val weatherJsonStringHolder = HttpRequest(ZIPCODE).execute().get()
            val fiveDayWeatherResult = Gson().fromJson(weatherJsonStringHolder, FiveDayWeatherResult::class.java)
            binding.rvWeatherList.adapter = WeatherListAdapter(fiveDayWeatherResult)
        } else {
            AlertDialog.Builder(activity).setTitle("No Internet Connection")
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
