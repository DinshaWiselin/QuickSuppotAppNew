package com.example.quicksuppotapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quicksuppotapp.data.RepositorySupSeeker
import com.example.quicksuppotapp.data.RepositorySupporter
import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.data.model.ProfileDataSupporter

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuickSupportViewModel :ViewModel(){
    private var supportRepo = RepositorySupSeeker()
    private var supporterRepo = RepositorySupporter()

    private val _support = MutableLiveData<MutableList<ProfileDataSupSeeker>>()
    val support: LiveData<MutableList<ProfileDataSupSeeker>>
    get() = _support

    private val _supporter = MutableLiveData<MutableList<ProfileDataSupporter>>()
    val supporter: LiveData<MutableList<ProfileDataSupporter>>
        get() = _supporter

    init{
       getsupportlist()
        getsupporterlist()
    }
    private fun getsupportlist() {
        viewModelScope.launch {
            _support.value = supportRepo.loadSupportSeeker()
        }
    }
    private fun getsupporterlist() {
        viewModelScope.launch {
            _supporter.value = supporterRepo.loadsupporter()
        }
    }
}