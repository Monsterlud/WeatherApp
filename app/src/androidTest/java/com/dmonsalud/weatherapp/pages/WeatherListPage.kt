package com.dmonsalud.weatherapp.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import com.dmonsalud.weatherapp.R
import com.dmonsalud.weatherapp.helpers.clickOn
import com.dmonsalud.weatherapp.helpers.typeInputIntoTextView

class WeatherListPage {

    /**
     * Screen Components
     */

    private val zipCodeEditText: ViewInteraction
        get() = Espresso.onView(ViewMatchers.withId(R.id.et_zip_code))

    private val zipCodeSubmitButton: ViewInteraction
        get() = Espresso.onView(ViewMatchers.withId(R.id.zipCode_submit_button))

    private val rvWeatherList: ViewInteraction
        get() = Espresso.onView(ViewMatchers.withId(R.id.rvWeatherList))

    private val TIME: ViewInteraction
        get() = Espresso.onView(ViewMatchers.withId(R.id.time))

    /**
     * Screen Actions
     */

    fun enterZipCode(
        zipCode: String = "80302"
    ): WeatherListPage {
        zipCodeEditText.clickOn()
        zipCodeEditText.typeInputIntoTextView(zipCode)
        zipCodeEditText.perform(pressImeActionButton())
        return this
    }

    fun clickSubmitButton(): WeatherListPage {
        zipCodeSubmitButton.check(matches(isCompletelyDisplayed()))
        zipCodeSubmitButton.perform(click())
        return this
    }

    fun verifyRecyclerViewIsDisplayed(): WeatherListPage {
        rvWeatherList.check(matches(isCompletelyDisplayed()))

        return this
    }
}
