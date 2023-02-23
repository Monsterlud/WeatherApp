package com.dmonsalud.weatherapp.di

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.dmonsalud.weatherapp.data.LocalDataSource
import com.dmonsalud.weatherapp.data.RemoteDataSource
import com.dmonsalud.weatherapp.data.local.datasource.LocalDataSourceImpl
import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherDAO
import com.dmonsalud.weatherapp.data.local.datasource.room.WeatherDatabase
import com.dmonsalud.weatherapp.data.remote.datasource.RemoteDataSourceImpl
import com.dmonsalud.weatherapp.data.remote.datasource.utils.EntityMappers
import com.dmonsalud.weatherapp.data.remote.datasource.utils.NetworkUtils
import com.dmonsalud.weatherapp.data.repository.WeatherListRepositoryImpl
import com.dmonsalud.weatherapp.di.KoinModule.Companion.WEATHER_DATABASE
import com.dmonsalud.weatherapp.presentation.WeatherListRepository
import com.dmonsalud.weatherapp.presentation.ui.WeatherListViewModel
import com.dmonsalud.weatherapp.utils.Constants
import com.google.gson.Gson
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

    fun provideDatabase(application: Application) : WeatherDatabase {
        return Room.databaseBuilder(
            application,
            WeatherDatabase::class.java,
            WEATHER_DATABASE
        ).build()
    }

    fun provideDao(database: WeatherDatabase) : WeatherDAO{
        return database.weatherDao()
    }

    single { LocalDataSourceImpl(get(), get(), get()) } bind LocalDataSource::class
    single { RemoteDataSourceImpl(get()) } bind RemoteDataSource::class
    single { WeatherListRepositoryImpl(get(), get()) } bind (WeatherListRepository::class)
    viewModel { WeatherListViewModel(get(), get(), get()) }

    single(qualifier = null) { moduleInstance.ktorClient() }
    single { NetworkUtils() }

    single { provideDatabase(androidApplication()) } bind WeatherDatabase::class
    single { provideDao(get()) }

    single { Gson() }
    single { EntityMappers() }
}



class KoinModule {
    val module get() = koinModule

    fun ktorClient() = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                }
            )
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

    companion object {
        const val WEATHER_DATABASE = "weather_database"
    }
}