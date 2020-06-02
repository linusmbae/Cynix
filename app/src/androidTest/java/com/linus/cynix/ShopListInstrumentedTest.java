package com.linus.cynix;

import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static androidx.test.espresso.action.ViewActions.click;
import static org.hamcrest.core.IsNot.not;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShopListInstrumentedTest {

    @Rule
    public ActivityTestRule<ProductsListActivity> activityTestRule=new ActivityTestRule<>(ProductsListActivity.class);

    @Test
    public void testOnItemClickFunction_returnsImage()throws Exception
    {
        View activityDecorView=activityTestRule.getActivity().getWindow().getDecorView();
        int images=  R.drawable.tyler;
        onData(anything())
                .inAdapterView(withId(R.id.baseGridView))
                .atPosition(0)
                .perform(click());
        onView(withText(images)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(images)));
    }

    @Test
    public  void testOnItemClick_returnsItemName()throws Exception
    {
        View activityDecorView=activityTestRule.getActivity().getWindow().getDecorView();
        String name="Men wear 1";
        onData(anything())
                .inAdapterView(withId(R.id.baseGridView))
                .atPosition(0)
                .perform(click());
        onView(withText(name)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(name)));
    }
}
