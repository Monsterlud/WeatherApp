package com.dmonsalud.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dmonsalud.ui.ui.WeatherListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = WeatherListFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.nav_host_fragment_container, fragment)
                .commit()
        }
    }
}
