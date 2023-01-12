package com.dmonsalud.weatherapp.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dmonsalud.weatherapp.MainActivity
import com.dmonsalud.weatherapp.pages.WeatherListPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherListTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun enterZipCodeAndSubmit() {
        WeatherListPage()
            // Given WeatherListFragment is visible
            // When
            .enterZipCode()
            // And
            .clickSubmitButton()
            // Then
            .verifyRecyclerViewIsDisplayed()
    }
}