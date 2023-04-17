package com.example.quicksuppotapp.data

import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.data.model.ProfileDataSupporter

class RepositorySupporter {
    fun loadsupporter(): MutableList<ProfileDataSupporter> {
        return mutableListOf(
            ProfileDataSupporter(
                "David", "Lubars", "Berlin","lubar.titno@gmail.com",
                "1514344443", "Gardening",R.drawable.brad),
            ProfileDataSupporter(
                "David", "Lubars", "Berlin", "lubar.titno@gmail.com",
                "1514344443", "Gardening",R.drawable.emma),
            ProfileDataSupporter(
                "David", "Lubars", "Berlin", "lubar.titno@gmail.com",
                "1514344443", "Gardening",R.drawable.jennifer),
            ProfileDataSupporter(
                "David", "Lubars", "Berlin", "lubar.titno@gmail.com",
                "1514344443", "Gardening",R.drawable.johnny),
        )
    }

}