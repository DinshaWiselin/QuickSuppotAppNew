package com.example.quicksuppotapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.databinding.SupportListitemBinding
import com.example.quicksuppotapp.ui.HomeSupporter_fragmentDirections

// Home Supporter-Recyclerview shows the list of Support Seeker(jobs)
class SupporterAdapter(private val supportProfile: MutableList<ProfileDataSupSeeker>)
    : RecyclerView.Adapter<SupporterAdapter.SupporterViewHolder>()  {

      var dataset=supportProfile

    inner class SupporterViewHolder(val binding: SupportListitemBinding)
        : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupporterViewHolder {
      val binding =SupportListitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
      return SupporterViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return supportProfile.size
    }

    override fun onBindViewHolder(holder: SupporterViewHolder, position: Int) {
        val supporter = dataset[position]
        //holder.binding.supportpreis.text=supporter.preis.toString()
        holder.binding.supportcity.text=supporter.location
        holder.binding.supportpreis.text=supporter.preisdetail.toString()
        holder.binding.supporttype.text=supporter.supporttype
        holder.binding.supseekName.text=supporter.name

        holder.binding.supoortcard.setOnClickListener{
            holder.itemView.findNavController()
            .navigate(HomeSupporter_fragmentDirections.actionHomeSupporterFragmentToDetailSupportFragment(supporter.name))
       }
    }
    fun setData(newDataset:MutableList<ProfileDataSupSeeker>){
        dataset=newDataset
        notifyDataSetChanged()
    }
}