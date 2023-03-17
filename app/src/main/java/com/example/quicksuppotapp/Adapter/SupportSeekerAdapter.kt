package com.example.quicksuppotapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.data.model.ProfileDataSupporter
import com.example.quicksuppotapp.databinding.SupportListitemBinding
import com.example.quicksuppotapp.databinding.SupporterListitemBinding

class SupportSeekerAdapter(private val supporterProfile: MutableList<ProfileDataSupporter>)
                          : RecyclerView.Adapter<SupportSeekerAdapter.SupportSeekerViewHolder>()
{

    class SupportSeekerViewHolder(val binding: SupporterListitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

             fun supporterbind(supporter:ProfileDataSupporter){
            binding.namesupporter.text=supporter.name
            binding.locationsupporter.text=supporter.location
            binding.typeofsupport.text=supporter.duration.toString()


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupportSeekerViewHolder {

        val binding =SupporterListitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SupportSeekerViewHolder(binding)

    }

    override fun getItemCount(): Int {
       return supporterProfile.size
    }

    override fun onBindViewHolder(holder: SupportSeekerViewHolder, position: Int) {
      holder.supporterbind(supporterProfile.get(position))
    }
}