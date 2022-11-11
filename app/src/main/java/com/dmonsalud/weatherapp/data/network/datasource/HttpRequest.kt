package com.dmonsalud.weatherapp.data.network.datasource

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class HttpRequest(private val zipCode: Int) : AsyncTask<String, Unit, String>() {
    var weatherJsonStringHolder = ""

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: String?): String {

        var httpURLConnection: HttpURLConnection? = null
        var lat: String = ""
        var lon: String = ""

        return try {
            val geoUrl =
                URL("https://api.openweathermap.org/geo/1.0/zip?zip=$zipCode,US&appid=$GEOAPIKEY")

            httpURLConnection = geoUrl.openConnection() as HttpURLConnection
            val geoResponseCode = httpURLConnection.responseCode

            if (geoResponseCode != 200) {
                throw IOException("The error from the server is $geoResponseCode")
            } else {
                val geoJsonStringHolder = geoUrl.readText()
                val geoResult =
                    Gson().fromJson(geoJsonStringHolder, GeocodingApiResponse::class.java)
                lat = geoResult.lat.toString()
                lon = geoResult.lon.toString()
                httpURLConnection.disconnect()

                Log.d(javaClass.simpleName, "doInBackground: Geocoding lat:$lat, lon:$lon")
            }

            val weatherUrl =
                URL("https://api.openweathermap.org/data/2.5/forecast?lat=$lat&lon=$lon&appid=$WEATHERAPIKEY")

            httpURLConnection = weatherUrl.openConnection() as HttpURLConnection
            val weatherResponseCode = httpURLConnection.responseCode

            if (weatherResponseCode != 200) {
                throw IOException("The error from the server is $weatherResponseCode")
            } else {
                weatherJsonStringHolder = weatherUrl.readText()
                return weatherJsonStringHolder
            }
        } catch (e: Exception) {
            Log.d(javaClass.simpleName, "doInBackground: $e: Failure")
            FAILURE
        }
    }

    companion object {
        private const val GEOAPIKEY = "6ac4a867247e4553cb55984a2afce83e"
        private const val WEATHERAPIKEY = "c55cf80588aaf17941120bfbc7e366e8"
        private const val SUCCESS = "Http Request Successful"
        private const val FAILURE = "Http Request Failure"
        var fiveDayWeatherResult: FiveDayWeatherResult? = null
    }
}
