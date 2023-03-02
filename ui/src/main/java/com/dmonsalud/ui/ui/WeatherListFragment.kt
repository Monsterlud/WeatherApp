package com.dmonsalud.ui.ui

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmonsalud.data.datasource.room.FiveDayWeatherResult
import com.dmonsalud.ui.R
import com.dmonsalud.ui.UiConstants
import com.dmonsalud.ui.databinding.FragmentListWeatherBinding
import java.util.regex.Pattern
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherListFragment() : Fragment() {

    private lateinit var binding: FragmentListWeatherBinding
    private val weatherListViewModel by viewModel<WeatherListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = getString(R.string.weatherapp_forecast)
        weatherListViewModel.initialize()
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

        val zipValidator = Pattern.compile(UiConstants.ZIP_REGEX)

        binding.zipCodeSubmitButton.setOnClickListener {
            val zipCode: String = binding.etZipCode.text.toString()
            val matcher = zipValidator.matcher(zipCode)

            val connectivityManager =
                activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    if (!matcher.matches()) {
                        binding.locationDisplay.setTextColor(Color.RED)
                        binding.locationDisplay.setText("Please enter a valid zip code")
                    } else if (zipCode.isEmpty()) {
                        clearRecyclerView()
                    } else {
                        binding.progressBar.isVisible = true
                        weatherListViewModel.saveFiveDayWeatherForecast(
                            zipCode, connectivityManager
                        )
                        weatherListViewModel.weatherForecast.collect {
                            binding.locationDisplay.setTextColor(resources.getColor(R.color.weather_dark))
                            binding.rvWeatherList.adapter = WeatherListAdapter(it)
                            binding.progressBar.isVisible = false
                            binding.locationDisplay.setText("Weather forecast for ${weatherListViewModel.location}")
                        }
                    }
                }
            }
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
        binding.recyclerClearButton.setOnClickListener {
            clearRecyclerView()
        }
        return binding.root
    }

    private fun clearRecyclerView() {
        binding.etZipCode.text.clear()
        binding.locationDisplay.setText("")
        binding.rvWeatherList.adapter = WeatherListAdapter(FiveDayWeatherResult(emptyList()))
        (binding.rvWeatherList.adapter as WeatherListAdapter).notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvWeatherList
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }
}
