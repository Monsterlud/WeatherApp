package com.dmonsalud.weatherapp.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.data.RemoteDataSource
import com.dmonsalud.weatherapp.data.local.datasource.LocalDataSourceImpl
import com.dmonsalud.weatherapp.data.remote.datasource.NetworkUtils
import com.dmonsalud.weatherapp.data.remote.datasource.RemoteDataSourceImpl
import com.dmonsalud.weatherapp.data.WeatherService
import com.dmonsalud.weatherapp.data.remote.datasource.WeatherServiceImpl
import com.dmonsalud.weatherapp.data.repository.WeatherListRepositoryImpl
import com.dmonsalud.weatherapp.model.Constants
import com.dmonsalud.weatherapp.presentation.WeatherListRepository
import com.dmonsalud.weatherapp.presentation.ui.WeatherListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.observer.ResponseObserver
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val koinModule = module {
    val moduleInstance = KoinModule()
    single { moduleInstance.getSharedPreferences(androidApplication()) }
    single { LocalDataSourceImpl(get()) } bind LocalDataSource::class
    single { RemoteDataSourceImpl(get()) } bind RemoteDataSource::class
    single { WeatherListRepositoryImpl(get(), get()) } bind (WeatherListRepository::class)
    viewModel { WeatherListViewModel(get(), get()) }

    single(qualifier = null) { moduleInstance.ktorClient() }
    single { WeatherServiceImpl(get()) } bind WeatherService::class
    single { NetworkUtils() }
}

class KoinModule {
    val module get() = koinModule

    fun getSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences(
            Constants.WEATHER_PREFERENCES, Context.MODE_PRIVATE
        )
    }

    fun ktorClient() = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(ResponseObserver) {
            onResponse { response ->
                Log.i("KOIN", "${response.status.value}")
            }
        }
        engine {
            connectTimeout = Constants.TIMEOUT
            socketTimeout = Constants.TIMEOUT
        }
    }
}