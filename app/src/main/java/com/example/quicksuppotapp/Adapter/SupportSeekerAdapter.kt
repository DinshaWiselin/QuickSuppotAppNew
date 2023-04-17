package com.example.quicksuppotapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quicksuppotapp.data.model.ProfileDataSupporter
import com.example.quicksuppotapp.databinding.SupporterListitemBinding
import com.example.quicksuppotapp.ui.HomeSupportSeeker_fragmentDirections

class SupportSeekerAdapter(private val supporterProfile: MutableList<ProfileDataSupporter>)
                          : RecyclerView.Adapter<SupportSeekerAdapter.SupportSeekerViewHolder>()
{
    val dataset=supporterProfile
    class SupportSeekerViewHolder(val binding: SupporterListitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupportSeekerViewHolder {

        val binding =SupporterListitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SupportSeekerViewHolder(binding)

    }

    override fun getItemCount(): Int {
       return supporterProfile.size
    }

    override fun onBindViewHolder(holder: SupportSeekerViewHolder, position: Int) {
        val supportseeker = dataset[position]
        holder.binding.photosupporter.setImageResource(supportseeker.img)
        holder.binding.namesupporter.text=supportseeker.name
        holder.binding.locationsupporter.text=supportseeker.location
        holder.binding.typeofsupport.text=supportseeker.supporttype

        holder.binding.supportercard.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(HomeSupportSeeker_fragmentDirections.actionHomeSupportSeekerFragmentToDetailFragment(supportseeker.name))
        }
    }
}