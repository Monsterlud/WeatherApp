package com.dmonsalud.weatherapp.presentation.ui

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmonsalud.weatherapp.R
import com.dmonsalud.weatherapp.databinding.FragmentListWeatherBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherListFragment() : Fragment() {

    private lateinit var binding: FragmentListWeatherBinding
    private val weatherListViewModel by viewModel<WeatherListViewModel>()

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
            val connectivityManager =
                activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            lifecycleScope.launch {
                weatherListViewModel.getFiveDayWeatherForecast(
                    binding.etZipCode.text.toString().toInt(), connectivityManager
                )
            }
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
}
