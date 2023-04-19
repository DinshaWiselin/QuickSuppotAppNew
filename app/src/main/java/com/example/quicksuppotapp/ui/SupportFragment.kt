package com.example.quicksuppotapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.databinding.FragmentSupportBinding

class SupportFragment : Fragment() {
     private lateinit var binding: FragmentSupportBinding
     private val viewModel:QuickSupportViewModel by viewModels()
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
        viewModel.currentUser.observe(viewLifecycleOwner){
            if (it==null){
                findNavController().navigate(R.id.logIn_fragment)
            }
            else{
                val mail =it.email.toString()
               // Toast.makeText(requireContext(),"hai $mail",Toast.LENGTH_SHORT).show()
            }
        }
    binding.LetSupport.setOnClickListener {
        findNavController().navigate(SupportFragmentDirections.actionSupportFragmentToHomeSupporterFragment())
    }
        binding.GetSupport.setOnClickListener {
            findNavController().navigate(SupportFragmentDirections.actionSupportFragmentToHomeSupportSeekerFragment())
        }

        binding.logouttext.setOnClickListener {
            viewModel.logout()
            findNavController().navigate(R.id.logIn_fragment)
        }
    }

}