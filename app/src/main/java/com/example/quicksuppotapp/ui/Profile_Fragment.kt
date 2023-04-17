package com.example.quicksuppotapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quicksuppotapp.Adapter.SupporterAdapter
import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.databinding.FragmentProfileBinding


class Profile_Fragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val viewModel:QuickSupportViewModel by viewModels()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.materialToolbar3.setNavigationOnClickListener{
            findNavController().navigateUp()
        }

        binding.saveProfile.setOnClickListener {
                val name=binding.nameProfile.text.toString()
                val surname=binding.surnameProfile.text.toString()
                val locat=binding.LocationProfile.text.toString()
                val email=binding.emailProfile.text.toString()
                val contact=binding.contactProfile.text.toString()
                val suptyp=binding.supportProfile.text.toString()
            val detail=binding.DetailProfile.text.toString()
            val supSeekerProf = ProfileDataSupSeeker(name,surname,locat,email,contact,suptyp,detail)
            viewModel.addsupport(supSeekerProf)
        }
    }

}