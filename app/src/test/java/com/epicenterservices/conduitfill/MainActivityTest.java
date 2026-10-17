package com.epicenterservices.conduitfill;

import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowWebView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void testActivityLaunchesAndWebViewIsConfiguredCorrectly() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                // Assert content view and WebView existence
                WebView webView = activity.findViewById(R.id.webView);
                assertNotNull("WebView should not be null", webView);

                // Assert WebSettings
                WebSettings webSettings = webView.getSettings();
                assertTrue("JavaScript should be enabled", webSettings.getJavaScriptEnabled());
                assertTrue("DOM Storage should be enabled", webSettings.getDomStorageEnabled());
                assertTrue("File Access should be allowed", webSettings.getAllowFileAccess());

                // Assert initial URL
                ShadowWebView shadowWebView = Shadows.shadowOf(webView);
                assertEquals("Should load local asset URL", "file:///android_asset/index.html", shadowWebView.getLastLoadedUrl());
            });
        }
    }

    @Test
    public void testOnBackPressed_WithWebViewHistory_GoesBack() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                WebView webView = activity.findViewById(R.id.webView);

                // Simulate web history by injecting a mock WebView
                WebView mockWebView = mock(WebView.class);
                when(mockWebView.canGoBack()).thenReturn(true);

                // We need to use reflection or package-private visibility to swap the webView,
                // but since webView is private, let's use reflection.
                try {
                    java.lang.reflect.Field field = MainActivity.class.getDeclaredField("webView");
                    field.setAccessible(true);
                    field.set(activity, mockWebView);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                activity.onBackPressed();

                verify(mockWebView).goBack();
            });
        }
    }

    @Test
    public void testOnBackPressed_WithoutWebViewHistory_FinishesActivity() {
         try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                WebView webView = activity.findViewById(R.id.webView);

                // Ensure there is no history (default state)
                assertFalse("WebView should not be able to go back initially", webView.canGoBack());

                activity.onBackPressed();

                // Activity should be finishing
                assertTrue("Activity should be finishing", activity.isFinishing());
            });
        }
    }
}
