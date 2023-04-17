package com.example.quicksuppotapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.databinding.FragmentSignupBinding


class signup : Fragment() {
    private lateinit var binding:FragmentSignupBinding
    private val viewModel: QuickSupportViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSignupBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.currentUser.observe(viewLifecycleOwner){
            if (it!=null){
                findNavController().navigate(R.id.supportFragment)
            }
        }
        viewModel.toast.observe(viewLifecycleOwner){
            if(it!=null){
                Toast.makeText(requireContext(),it, Toast.LENGTH_SHORT).show()
            }
        }
        binding.signupid.setOnClickListener {
            val mail= binding.signupmail.text.toString()
            val pass=binding.signuppass.text.toString()
            if (!mail.isNullOrEmpty()&&!pass.isNullOrEmpty()){
                viewModel.signup(mail,pass)
            }
            findNavController().navigate(R.id.welcome_fragment)
        }
        binding.cancelsignup.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}