package com.epicenterservices.conduitfill;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long startTime = System.nanoTime();
        super.onCreate(savedInstanceState);
        long endTime = System.nanoTime();
        Log.d("Performance", "Activity onCreate time (ns): " + (endTime - startTime));
        // Conduit Fill v2 MainActivity entrypoint
    }
}
