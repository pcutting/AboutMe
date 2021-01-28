package com.nevie.aboutme

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class bio : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio)

        // Enables Always-on
        setAmbientEnabled()
    }
}