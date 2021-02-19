package com.nevie.aboutme

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nevie.aboutme.databinding.FragmentHobbyBinding
import com.nevie.aboutme.repositories.HobbyRepository

class HobbyFragment: Fragment(R.layout.fragment_hobby){

    private var fragmentHobbyBinding: FragmentHobbyBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHobbyBinding.bind(view)
        fragmentHobbyBinding = binding

        binding.hobbiesFab.setOnClickListener {
            Log.d("FAB", "i got clicked in onViewCreated")
        }

        binding.hobbyList.adapter = HobbiesViewAdapter(HobbyRepository.hobbies)
        binding.hobbyList.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)


    }


    // TODO Review this.  was causing bugs.  I think it's totally not needed.
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        //val binding = FragmentHobbyBinding.bind(container.rootView)
//        super.onCreateView(inflater, container, savedInstanceState)
//
//
//        return container
//    }

}