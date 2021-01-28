package com.nevie.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bio = findViewById<Button>(R.id.bio_button)
        val family = findViewById<Button>(R.id.my_family_button)
        val journey = findViewById<Button>(R.id.programming_button)

        bio.setOnClickListener {

        }

        family.setOnClickListener {

        }

        journey.setOnClickListener{

        }



    }
}