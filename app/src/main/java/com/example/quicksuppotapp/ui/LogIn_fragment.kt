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
import com.example.quicksuppotapp.databinding.FragmentLogInFragmentBinding

class LogIn_fragment : Fragment() {
    private lateinit var binding: FragmentLogInFragmentBinding
    private val viewModel: QuickSupportViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLogInFragmentBinding.inflate(inflater)
        /* var username:String
        var password:String
        binding.SignInLogin.setOnClickListener {
            username= binding.NameLogin.text.toString()
            password=binding.PasswordLogin.text.toString()
            if (username.equals("admin") && (password.equals("admin"))){
               Toast.makeText(context, "Login Succesful", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.supportFragment)
            }
            else{
               Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }

        }*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.toast.observe(viewLifecycleOwner){
            if(it!=null){
                Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.currentUser.observe(viewLifecycleOwner){
            if (it!=null){
                findNavController().navigate(R.id.supportFragment)
            }
        }

        binding.SignInLogin.setOnClickListener {
            val email = binding.NameLogin.text.toString()
            val password = binding.PasswordLogin.text.toString()
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                viewModel.login(email, password)
            }
        }
        binding.register.setOnClickListener {
            findNavController().navigateUp()
        }

    }
}