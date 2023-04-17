package com.example.quicksuppotapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController

import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.databinding.FragmentDetailFragmentBinding
import com.example.quicksuppotapp.databinding.FragmentDetailSupportBinding

class DetailSupportFragment : Fragment() {

private lateinit var binding: FragmentDetailSupportBinding
private val viewModel:QuickSupportViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailSupportBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.BottomVav.setupWithNavController(findNavController())

        //val supSurname = requireArguments().getString("supSurname")
        val supName = requireArguments().getString("supName")
        viewModel.support.observe(viewLifecycleOwner){list->
         val support = list.find { it.name==supName}
            if (support != null) {
                viewModel.setSup(support)
            }
            viewModel.sup.observe(viewLifecycleOwner) {
                binding.supSeekername.text = it.name
                binding.supSeekersurname.text = it.surname
                binding.supSeekerLocation.text = it.location
                binding.supSeekerEmail.text=it.email
                binding.supSeekercontactno.text=it.contactno
                binding.supporttypeseeker.text=it.supporttype
                binding.supportPreis.text = it.preisdetail.toString()
                binding.materialToolbar2.title=it.name
                binding.contact.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.putExtra(
                        Intent.EXTRA_TEXT,
                       "I am ready to Support you")
                    intent.type = "text/plain"
                    val chooser = Intent.createChooser(intent, "Quick Support")
                    startActivity(chooser)
                }
                binding.materialToolbar2.setNavigationOnClickListener{
                    findNavController().navigateUp()
                }

            }

        }

    }

}