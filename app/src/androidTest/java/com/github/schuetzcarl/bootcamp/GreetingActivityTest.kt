package com.github.schuetzcarl.bootcamp

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GreetingActivityTest {

    @Test
    fun correctGreetingMessageIsDisplayed(){
        val intent = Intent(ApplicationProvider.getApplicationContext(), GreetingActivity::class.java)
        intent.putExtra("userName", "Carl")

        val act = ActivityScenario.launch<GreetingActivity>(intent)
        Espresso
            .onView(ViewMatchers.withId(R.id.greetingMessage))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello Carl")))
        act.close()
    }

    @Test
    fun greetingMessageWithoutIntent(){
        val act = ActivityScenario.launch(GreetingActivity::class.java)
        Espresso
            .onView(ViewMatchers.withId(R.id.greetingMessage))
            .check(ViewAssertions.matches(ViewMatchers.withText("Greetings !")))
        act.close()
    }
}