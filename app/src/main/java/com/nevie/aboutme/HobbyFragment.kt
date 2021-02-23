package com.nevie.aboutme

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nevie.aboutme.databinding.FragmentHobbyBinding
import com.nevie.aboutme.models.Hobby

class HobbyFragment: Fragment(R.layout.fragment_hobby), HobbyNewDialogFragment.OnClickListener {
    private val TAG = "HobbyFragment"
    private var fragmentHobbyBinding: FragmentHobbyBinding? = null

    private fun showDialog() {
        val dialog = HobbyNewDialogFragment.create(this)
        dialog.show(parentFragmentManager , "HobbyDialogFragment")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHobbyBinding.bind(view)
        fragmentHobbyBinding = binding
        binding.hobbiesFab.setOnClickListener {
            Log.d("FAB", "Fab got clicked in onViewCreated")
            showDialog()
        }
        binding.hobbyList.adapter = HobbiesViewAdapter()
        binding.hobbyList.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        val bar = (activity as AppCompatActivity).supportActionBar
        bar?.title = "AboutMe Hobbies"
    }

    override fun onDialogPositiveClick(hobby: Hobby?) {
        Log.d(TAG, " onDialogPositiveClick save clicked" )
        //Nothing to do, is handled by caller
    }

    override fun onDialogNegativeClick(hobby : Hobby?) {
        Log.d(TAG, " onDialogNegativeClick cancel clicked")
        //Nothing to do in this point.  Here for discussion on medium.com
    }


}