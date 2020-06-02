package com.linus.cynix;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.click;
import androidx.test.filters.LargeTest;

import com.linus.cynix.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentedTest {
@Rule
    public ActivityTestRule<MainActivity>activityTestRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestButtonClick()throws Exception {
        onView(withId(R.id.FindButton)).perform(click());
    }

}
