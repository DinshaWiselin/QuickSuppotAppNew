package com.example.quicksuppotapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController

import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.databinding.FragmentDetailFragmentBinding


class Detail_fragment : Fragment() {
    private lateinit var binding:FragmentDetailFragmentBinding
    private val viewModel:QuickSupportViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavi.setupWithNavController(findNavController())
        val supseekName = requireArguments().getString("supseekName")
        viewModel.supporter.observe(viewLifecycleOwner){list->
            val supporter = list.find { it.name==supseekName}
            if (supporter != null) {
                viewModel.setSupSeek(supporter)
            }
            viewModel.supseek.observe(viewLifecycleOwner) {
                if (it.img!=null) {
                    binding.imageDetail.setImageResource(it.img!!)
                }
             binding.supporterName.text=it.name
             binding.supporterLocation.text=it.location
             binding.supporterEmail.text=it.email
             binding.supportercontact.text=it.contactno.toString()
                binding.supporterskills.text=it.supporttype
                binding.materialToolbar.title=it.name
                binding.contactsuporterbutton.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.putExtra(
                        Intent.EXTRA_TEXT,
                        "I am in need your Support")
                    intent.type = "text/plain"
                    val chooser = Intent.createChooser(intent, "Quick Support")
                    startActivity(chooser)
                }
                binding.materialToolbar.setNavigationOnClickListener{
                    findNavController().navigateUp()
                }

            }

        }
    }

}