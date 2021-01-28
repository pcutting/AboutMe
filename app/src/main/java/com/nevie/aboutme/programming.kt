package com.nevie.aboutme

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class programming : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programming)

        // Enables Always-on
        setAmbientEnabled()
    }
}