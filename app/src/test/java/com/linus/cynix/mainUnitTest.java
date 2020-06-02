package com.linus.cynix;

import android.os.Build;
import android.widget.Button;

import com.linus.cynix.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.TestCase.assertTrue;

@Config(sdk = Build.VERSION_CODES.O_MR1)
@RunWith(RobolectricTestRunner.class)
public class mainUnitTest {

    private MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity= Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateButton()throws Exception {
        Button CheckButton=activity.findViewById(R.id.FindButton);
        assertTrue("Check Available Products".equals(CheckButton.getText().toString()));
    }
}
