package com.example.quicksuppotapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.databinding.FragmentSupportBinding

class SupportFragment : Fragment() {
     private lateinit var binding: FragmentSupportBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSupportBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    binding.LetSupport.setOnClickListener {
        findNavController().navigate(R.id.homeSupporter_fragment)
    }
        binding.GetSupport.setOnClickListener {
            findNavController().navigate(R.id.homeSupportSeeker_fragment)
        }
    }

}