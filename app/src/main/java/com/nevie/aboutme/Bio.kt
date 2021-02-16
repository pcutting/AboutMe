package com.nevie.aboutme

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


class Bio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio)

        var bar = supportActionBar
        bar?.title = resources.getString(R.string.activity_xxx_title)
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