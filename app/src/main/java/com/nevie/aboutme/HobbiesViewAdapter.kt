package com.nevie.aboutme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nevie.aboutme.databinding.HobbyItemBinding
import com.nevie.aboutme.models.Hobby
import com.nevie.aboutme.repositories.HobbyRepository

class HobbiesViewAdapter : RecyclerView.Adapter<HobbiesViewAdapter.HobbiesViewHolder>()
{
    class HobbiesViewHolder(private val binding: HobbyItemBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun bind(hobby: Hobby) {
                    binding.hobbyItemTextView.text = hobby.description
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HobbyItemBinding.inflate(layoutInflater, parent, false)
        return HobbiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HobbiesViewHolder, position: Int) {
        holder.bind(HobbyRepository.hobbies[position])
    }

    override fun getItemCount() = HobbyRepository.hobbies.size
}