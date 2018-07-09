package com.example.krishna.unittestingusingrobolectric;

import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SampleTest {

    private SampleActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(SampleActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldHaveDefaultMargin() throws Exception {
        TextView textView = (TextView) activity.findViewById(R.id.hello_textview);
        int bottomMargin = ((LinearLayout.LayoutParams) textView.getLayoutParams()).bottomMargin;
        assertEquals(5, bottomMargin);
        int topMargin = ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin;
        assertEquals(5, topMargin);
        int rightMargin = ((LinearLayout.LayoutParams) textView.getLayoutParams()).rightMargin;
        assertEquals(10, rightMargin);
        int leftMargin = ((LinearLayout.LayoutParams) textView.getLayoutParams()).leftMargin;
        assertEquals(10, leftMargin);
       assertEquals("Hello World!",textView.getText().toString());
    }
    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveCorrectAppName() throws Exception {
        String hello = activity.getResources().getString(R.string.app_name);
        assertThat(hello, equalTo("UnitTestingUsibgRobolectric"));
    }
    @Test
    public void buttonClickShouldStartNewActivity() throws Exception
    {
        Button button = (Button) activity.findViewById( R.id.nextButton );
        button.performClick();
        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        assertEquals(MainActivity.class.getCanonicalName(), intent.getComponent().getClassName());
    }
    @Test
    public void testButtonClickShouldShowToast() throws Exception {
        SampleActivity activity = Robolectric.buildActivity(SampleActivity.class).create().get();
        Button view = (Button) activity.findViewById(R.id.nextButton);
        assertNotNull(view);
        view.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Krishna") );
    }

}
