package com.example.krishna.unittestingusingrobolectric;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SampleTestUnitTest {

    private MainActivity mainActivity;
//    private Button pressMeButton;


    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
//        pressMeButton = (Button) mainActivity.findViewById(R.id.press_me_button);

    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mainActivity);
    }

    @Test
    public void continueShouldLaunchMineActivity() {
        // define the expected results
        Intent expectedIntent = new Intent(mainActivity, SampleActivity.class);
        // click the continue button
        mainActivity.findViewById(R.id.continue_button).callOnClick();
        // get the actual results
        ShadowActivity shadowActivity = shadowOf(mainActivity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        // check if the expected results match the actual results
        assertTrue(expectedIntent.filterEquals(actualIntent));
    }

//    @Test
//    public void validateTextViewContent() {
//        TextView tvHelloWorld = (TextView) mainActivity.findViewById(R.id.tvHelloWorld);
//        assertNotNull("TextView could not be found", tvHelloWorld);
//        assertTrue("TextView contains incorrect text",
//                "Hello world!".equals(tvHelloWorld.getText().toString()));
//    }



}
