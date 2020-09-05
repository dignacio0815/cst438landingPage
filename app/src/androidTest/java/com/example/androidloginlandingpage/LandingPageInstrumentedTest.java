package com.example.androidloginlandingpage;

import android.content.Context;
import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LandingPageInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.androidloginlandingpage", appContext.getPackageName());
    }

    @Test
    public void verifyIntent() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = LandingPageActivity.getIntent(appContext, "denize", "hello_world");
        assertEquals(intent.getStringExtra("testIntentUsername"), "denize");
        assertEquals(intent.getStringExtra("testIntentPassword"), "hello_world");
    }
}