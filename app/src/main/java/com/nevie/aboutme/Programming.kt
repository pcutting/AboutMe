package com.nevie.aboutme



import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.nevie.aboutme.databinding.ActivityProgrammingBinding

class Programming : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProgrammingBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_programming)




        var bar = supportActionBar
        bar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}