package com.nevie.aboutme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nevie.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.bioButton.setOnClickListener {
            val intent = Intent(this, Bio::class.java)
            startActivity(intent)
        }

        binding.myFamilyButton.setOnClickListener {
            val intent = Intent(this, MyFamily::class.java)
            startActivity(intent)
        }

        binding.programmingButton.setOnClickListener{
            val intent = Intent(this, Programming::class.java)
            startActivity(intent)
        }



    }
}