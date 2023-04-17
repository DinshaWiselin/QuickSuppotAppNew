package com.example.quicksuppotapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.data.model.ProfileDataSupporter
import com.example.quicksuppotapp.databinding.FragmentProfileBinding
import com.example.quicksuppotapp.databinding.FragmentProfileSupporterBinding

/**
 * A simple [Fragment] subclass.
 * Use the [profile_supporter.newInstance] factory method to
 * create an instance of this fragment.
 */
class profile_supporter : Fragment() {
    private lateinit var binding: FragmentProfileSupporterBinding
    private val viewModel:QuickSupportViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentProfileSupporterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.materialToolbar4.setNavigationOnClickListener{
            findNavController().navigateUp()
        }
      binding.saveProfile2.setOnClickListener {
         val profbild = R.drawable.keanu
          val name=binding.nameSupProfile.text.toString()
          val surname=binding.surnameSupProfile.text.toString()
          val locat=binding.locationSupProfile.text.toString()
          val email=binding.emailSupProfile.text.toString()
          val contact=binding.contactSupProfile.text.toString()
          val suptyp=binding.skillSupProfile.text.toString()
        val supProfile = ProfileDataSupporter(name,surname,locat,email,contact,suptyp,profbild)
         viewModel.addsupporter(supProfile)

      }
    }
}