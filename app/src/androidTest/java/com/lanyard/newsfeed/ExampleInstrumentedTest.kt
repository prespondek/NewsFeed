package com.lanyard.newsfeed

import androidx.test.runner.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.platform.app.InstrumentationRegistry
import com.squareup.okhttp.mockwebserver.MockResponse;

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import okhttp3.mockwebserver.MockWebServer
import org.junit.After


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)
    private val server = MockWebServer()


    @Before
    fun setup() {
        server.start()

    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        onView(withId(R.id.news_item_list)).check(matches(isDisplayed()))
    }

    @After
    fun teardown() {
        server.shutdown()
    }
}
