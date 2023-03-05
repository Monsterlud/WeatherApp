package com.dmonsalud.weatherapp.di

import android.app.Application
import android.util.Log
import androidx.room.Room

import com.dmonsalud.data.LocalDataSource
import com.dmonsalud.data.RemoteDataSource
import com.dmonsalud.data.datasource.LocalDataSourceImpl
import com.dmonsalud.data.datasource.room.WeatherDAO
import com.dmonsalud.data.datasource.room.WeatherDatabase
import com.dmonsalud.data.datasource.RemoteDataSourceImpl
import com.dmonsalud.data.datasource.utils.EntityMappers
import com.dmonsalud.data.datasource.utils.NetworkUtils
import com.dmonsalud.ui.ui.WeatherListViewModel
import com.dmonsalud.data.WeatherListRepository
import com.dmonsalud.data.repository.WeatherListRepositoryImpl
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
import com.dmonsalud.weatherapp.AppConstants

val appModule = module {
    val moduleInstance = AppModule()

    fun provideDatabase(application: Application): WeatherDatabase {
        return Room.databaseBuilder(
            application,
            WeatherDatabase::class.java,
            AppModule.WEATHER_DATABASE
        ).build()
    }

    fun provideDao(database: WeatherDatabase): WeatherDAO {
        return database.weatherDao()
    }

    single { LocalDataSourceImpl(get(), get(), get()) } bind LocalDataSource::class
    single { RemoteDataSourceImpl(get()) } bind RemoteDataSource::class
    single { WeatherListRepositoryImpl(get(), get(), get()) } bind (WeatherListRepository::class)
    viewModel { WeatherListViewModel(get(), get()) }

    single(qualifier = null) { moduleInstance.ktorClient() }
    single { NetworkUtils() }
    single { EntityMappers() }
    single { Gson() }

    single { provideDatabase(androidApplication()) } bind WeatherDatabase::class
    single { provideDao(get()) }

    single { Gson() }
    single { EntityMappers() }
}


class AppModule {

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
            connectTimeout = AppConstants.TIMEOUT
            socketTimeout = AppConstants.TIMEOUT
        }
    }

    companion object {
        const val WEATHER_DATABASE = "weather_database"
    }
}