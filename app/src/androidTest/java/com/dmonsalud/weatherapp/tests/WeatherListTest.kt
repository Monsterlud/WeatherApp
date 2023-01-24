package com.dmonsalud.weatherapp.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dmonsalud.weatherapp.MainActivity
import com.dmonsalud.weatherapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherListTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testZipcodeEntryAndSubmit() {
        onView(withId(R.id.et_zip_code)).perform(typeText("80302"))
        onView(withId(R.id.zipCode_submit_button)).perform(click())
        onView(withId(R.id.rvWeatherList)).check(matches(isCompletelyDisplayed()))
    }
}