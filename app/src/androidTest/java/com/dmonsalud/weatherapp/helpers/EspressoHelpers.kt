package com.dmonsalud.weatherapp.helpers

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

internal fun ViewInteraction.clickOn() = perform(ViewActions.click())

internal fun ViewInteraction.isDisplayed() =
    check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

internal fun ViewInteraction.typeInputIntoTextView(text: String) = run {
    if (text.isNotEmpty()) {
        this.perform(ViewActions.typeText(text.substring(0, 1)))
        for (i in 1 until text.length) {
            this.perform(ViewActions.typeTextIntoFocusedView(text.substring(i, i + 1)))
        }
    }
}
