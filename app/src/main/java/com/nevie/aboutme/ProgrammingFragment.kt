package com.nevie.aboutme

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class ProgrammingFragment: Fragment(R.layout.fragment_programming){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bar = (activity as AppCompatActivity).supportActionBar
        bar?.title = "AboutMe Programming"
    }
}