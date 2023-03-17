package com.example.quicksuppotapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quicksuppotapp.Adapter.SupporterAdapter
import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.databinding.FragmentProfileBinding


class Profile_Fragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var adapter: SupporterAdapter
    private lateinit var supseekerProfile:MutableList<ProfileDataSupSeeker>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

}