package com.nevie.aboutme

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class myFamily : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_family)

        // Enables Always-on
        setAmbientEnabled()
    }
}