package com.example.quicksuppotapp.data

import com.example.quicksuppotapp.R
import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.data.model.ProfileDataSupporter

class RepositorySupporter {
    fun loadsupporter(): MutableList<ProfileDataSupporter> {
        return mutableListOf(
            ProfileDataSupporter(
                "Brad", "Lubars", "Berlin","lubar.titno@gmail.com",
                "1514344443", "Gardening",R.drawable.brad),
            ProfileDataSupporter(
                "Emma", "Tommy", "Berlin", "lubar.titno@gmail.com",
                "1514344443", "Cleaner",R.drawable.emma),
            ProfileDataSupporter(
                "Jennifer", "Hunt", "Paderborn", "lubar.titno@gmail.com",
                "1514344443", "Driver",R.drawable.jennifer),
            ProfileDataSupporter(
                "Johnny", "Dep", "Leipzig", "lubar.titno@gmail.com",
                "1514344443", "Gardening",R.drawable.johnny),
            ProfileDataSupporter(
                "Bradly", "Ludowitz", "München","lubar.titno@gmail.com",
                "1514344443", "House Keeper",R.drawable.brad),
            ProfileDataSupporter(
                "Emely", "Ludwig", "Frankfurt", "lubar.titno@gmail.com",
                "1514344443", "Housekeeping",R.drawable.emma),
            ProfileDataSupporter(
                "Jennifera", "Lubarsa", "Berlin", "lubar.titno@gmail.com",
                "1514344443", "Gardening",R.drawable.jennifer),
            ProfileDataSupporter(
                "Jack", "Daniel", "Frankfurt", "lubar.titno@gmail.com",
                "1514344443", "Shopping",R.drawable.johnny),
            ProfileDataSupporter(
                "Abilash", "Ludowitz", "München","lubar.titno@gmail.com",
                "1514344443", "House Keeper",R.drawable.abilash),
            ProfileDataSupporter(
                "Arvinth", "Ludwig", "Frankfurt", "lubar.titno@gmail.com",
                "1514344443", "Housekeeping",R.drawable.arvinth),
            ProfileDataSupporter(
                "Dora", "Lubarsa", "Berlin", "lubar.titno@gmail.com",
                "1514344443", "Gardening",R.drawable.dora),
            ProfileDataSupporter(
                "kamelia", "Daniel", "Frankfurt", "lubar.titno@gmail.com",
                "1514344443", "Assistant",R.drawable.kamelia),
            ProfileDataSupporter(
                "Menaka", "Ludwig", "Frankfurt", "lubar.titno@gmail.com",
                "1514344443", "Housekeeping",R.drawable.menaka),
            ProfileDataSupporter(
                "Sandra", "Lubarsa", "Berlin", "lubar.titno@gmail.com",
                "1514344443", "Gardening",R.drawable.sandra),
            ProfileDataSupporter(
                "Neha", "Daniel", "Frankfurt", "lubar.titno@gmail.com",
                "1514344443", "Shopping",R.drawable.neha),
        )
    }

}