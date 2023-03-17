package com.example.quicksuppotapp.data

import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.data.model.ProfileDataSupporter

class RepositorySupporter {
    fun loadsupporter(): MutableList<ProfileDataSupporter> {
        return mutableListOf(
            ProfileDataSupporter(
                "David", "Lubars", "Berlin", "lubar.titno@gmail.com",
                1514344443, "Gardening", 12.00, 2),
            ProfileDataSupporter(
                "David", "Lubars", "Berlin", "lubar.titno@gmail.com",
                1514344443, "Gardening", 12.00, 2),
            ProfileDataSupporter(
                "David", "Lubars", "Berlin", "lubar.titno@gmail.com",
                1514344443, "Gardening", 12.00, 2),
            ProfileDataSupporter(
                "David", "Lubars", "Berlin", "lubar.titno@gmail.com",
                1514344443, "Gardening", 12.00, 2)
        )
    }
}