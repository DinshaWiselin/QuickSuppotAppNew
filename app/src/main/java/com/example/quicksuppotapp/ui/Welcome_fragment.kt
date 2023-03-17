package com.example.quicksuppotapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.databinding.FragmentWelcomeFragmentBinding

class Welcome_fragment : Fragment() {
     private lateinit var binding: FragmentWelcomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeFragmentBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signin.setOnClickListener {
            findNavController().navigate(R.id.logIn_fragment)
        }
    }

}