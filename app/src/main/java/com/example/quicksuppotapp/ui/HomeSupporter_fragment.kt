package com.example.quicksuppotapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.quicksuppotapp.Adapter.SupporterAdapter
import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.databinding.FragmentHomeSupporterFragmentBinding

class HomeSupporter_fragment : Fragment() {
     private lateinit var binding: FragmentHomeSupporterFragmentBinding
     private val viewModel:QuickSupportViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeSupporterFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val supporterAdapter =SupporterAdapter(viewModel.support.value!!)
        binding.HomeSupporterRecycler.adapter=supporterAdapter

        /*val snapHelper= PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.HomeSupporterRecycler)*/

        binding.bottomNavigationView.setupWithNavController(findNavController())
    }



}