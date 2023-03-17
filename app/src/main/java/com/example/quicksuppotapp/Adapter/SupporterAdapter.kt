package com.example.quicksuppotapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.databinding.SupportListitemBinding

// Home Supporter-Recyclerview show the list of Support Seeker(jobs)
class SupporterAdapter(private val supportProfile: MutableList<ProfileDataSupSeeker>)
    : RecyclerView.Adapter<SupporterAdapter.SupporterViewHolder>()  {



    class SupporterViewHolder(val binding: SupportListitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun supportbind(supSeeker:ProfileDataSupSeeker){
            binding.supportpreis.text=supSeeker.preis.toString()
            binding.supportcity.text=supSeeker.location
            binding.supportduration.text=supSeeker.duration.toString()
            binding.supporttype.text=supSeeker.supporttype

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupporterViewHolder {

       val binding =SupportListitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SupporterViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return supportProfile.size
    }

    override fun onBindViewHolder(holder: SupporterViewHolder, position: Int) {

        holder.supportbind(supportProfile.get(position))


    }
}