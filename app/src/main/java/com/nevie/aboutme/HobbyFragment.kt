package com.nevie.aboutme

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nevie.aboutme.databinding.FragmentHobbyBinding
import com.nevie.aboutme.repositories.HobbyRepository

class HobbyFragment: Fragment(R.layout.fragment_hobby), HobbyNewDialogFragment.HobbyDialogListener {

    private var fragmentHobbyBinding: FragmentHobbyBinding? = null

    private fun showDialog() {
        val dialog = HobbyNewDialogFragment()
        dialog.show(childFragmentManager , "HobbyDialogFragment")
        //getFragmentManager()?.let { dialog.show(it, "HobbyDialogFragment") }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHobbyBinding.bind(view)
        fragmentHobbyBinding = binding

        binding.hobbiesFab.setOnClickListener {
            Log.d("FAB", "Fab got clicked in onViewCreated")
            showDialog()
//            val newFragment = NewHobbyFragment()
//            activity?.supportFragmentManager?.let { it1 -> newFragment.show(it1, "hobbies") }


        }

        binding.hobbyList.adapter = HobbiesViewAdapter(HobbyRepository.hobbies)
        binding.hobbyList.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        Log.d("HobbyFragment", "Dialog Save clicked")

    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        Log.d("HobbyFragment", "Dialog, cancel clicked")
    }





}