package com.example.quicksuppotapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.quicksuppotapp.Adapter.SupportSeekerAdapter
import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.databinding.FragmentHomeSupportSeekerFragmentBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeSupportSeeker_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeSupportSeeker_fragment : Fragment() {
      private lateinit var binding:FragmentHomeSupportSeekerFragmentBinding
    private val viewModel:QuickSupportViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeSupportSeekerFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadQuotes()
        viewModel.quotes.observe(viewLifecycleOwner) {
            if (it != null)
            {
                binding.textView.text=it.content

            }
        }
      Log.d("HomesupSeeker recycler",viewModel.supporter.value.toString())
        val supSeekerAdapter = SupportSeekerAdapter(viewModel.supporter.value!!)
        binding.HomesupSeekerRecycler.adapter=supSeekerAdapter
        binding.bottomNaviHome.setupWithNavController(findNavController())
        binding.bottomNaviHome.selectedItemId=R.id.homeSupportSeeker_fragment
       /* val snapHelper= PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.HomesupSeekerRecycler)*/

        binding.filterSupportSeeker.setOnClickListener {
            findNavController()
                .navigate(HomeSupportSeeker_fragmentDirections.actionHomeSupportSeekerFragmentToPopupSupportSeeker())
        }

        binding.toolbarSupseeker.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }



}