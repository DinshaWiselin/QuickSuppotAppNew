package com.example.quicksuppotapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.quicksuppotapp.Adapter.SupporterAdapter
import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.databinding.FragmentHomeSupporterFragmentBinding

class HomeSupporter_fragment : Fragment() {
     private lateinit var binding: FragmentHomeSupporterFragmentBinding
     private val viewModel:QuickSupportViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding= FragmentHomeSupporterFragmentBinding.inflate(inflater)
        //setSupportActionBar(binding.toolbar2))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadNewQuotes()
        viewModel.quotes1.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.quotestextview.text=it.random().quote
            }
        }

        /*viewModel.loadEmojis()
        viewModel.emojis.observe(viewLifecycleOwner) {
            if (it != null) {
                //binding.textView3.text=it
                binding.emojiimg.setImageResource(it.image)
            }
        }*/

        val supporterAdapter =SupporterAdapter(viewModel.support.value!!)
        binding.HomeSupporterRecycler.adapter=supporterAdapter

        viewModel.support.observe(viewLifecycleOwner){
            supporterAdapter.setData(it)
        }
       /* val snapHelper= PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.HomeSupporterRecycler)*/
       // binding.toolbarsuporter.setLogo(R.drawable.filter1)
     binding.filterSupporter.setOnClickListener {
      findNavController().navigate(HomeSupporter_fragmentDirections.actionHomeSupporterFragmentToPopUpFragment())
     }
        binding.bottomNavigationView.setupWithNavController(findNavController())
        binding.bottomNavigationView.selectedItemId=R.id.homeSupporter_fragment
       binding.toolbarsuporter.setNavigationOnClickListener{
           findNavController().navigate(R.id.supportFragment)
       }
    }



}