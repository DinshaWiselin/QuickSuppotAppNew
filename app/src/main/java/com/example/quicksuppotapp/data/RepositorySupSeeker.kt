package com.example.quicksuppotapp.data

import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker

class RepositorySupSeeker {
    fun loadSupportSeeker(): MutableList<ProfileDataSupSeeker>{
        return mutableListOf(
                ProfileDataSupSeeker("Ulrich", "Mueller", "Berlin", "ulrich.man1@gmail.com",
                    "1514344443", "Gardening" ,"12.00"),
            ProfileDataSupSeeker("Raman", "Raguva", "Leipzig", "Rama@ymail.com",
                "1514344443", "Cleaning" ,"11.00"),
            ProfileDataSupSeeker("Peter", "Neumann", "Paderborn", "Peter@gmail.com",
                "1514344443", "Shopping" ,"9.00"),
            ProfileDataSupSeeker("Maria", "Weinfurt", "Frankfurt", "Mari@gmail.com",
                "1514344443", "Driving" ,"12.50"),
            ProfileDataSupSeeker("Lilli", "Lustig", "Berlin", "Lillu@gmail.com",
                "1514344443", "Cleaning" ,"12.00"),
            ProfileDataSupSeeker("Sonya", "Roybert", "Berlin", "Sony@gmail.com",
                "1514344443", "Gardening" ,"10.00"),
            ProfileDataSupSeeker("Hans", "Imgluck", "München", "Hansa@gmail.com",
                "1514344443", "Helper" ,"15.00"),
                    ProfileDataSupSeeker("Fritz", "Mayer", "Barcelona", "Fritzi@gmail.com",
            "1514344443", "Cleaning" ,"8.00"),
            ProfileDataSupSeeker("Ulrich", "Mueller", "Berlin", "ulrich.man1@gmail.com",
                "1514344443", "House keeping" ,"12.00"),
            ProfileDataSupSeeker("Raman", "Raguva", "Leipzig", "Rama@ymail.com",
                "1514344443", "Driver" ,"11.00"),
            ProfileDataSupSeeker("Peter", "Neumann", "Paderborn", "Peter@gmail.com",
                "1514344443", "Party Organizer" ,"9.00"),
            ProfileDataSupSeeker("Maria", "Weinfurt", "Frankfurt", "Mari@gmail.com",
                "1514344443", "Babysitting" ,"12.50"),
            ProfileDataSupSeeker("Lilli", "Lustig", "Berlin", "Lillu@gmail.com",
                "1514344443", "Gardening" ,"12.00"),
            ProfileDataSupSeeker("Sonya", "Roybert", "Berlin", "Sony@gmail.com",
                "1514344443", "Gardening" ,"10.00"),
            ProfileDataSupSeeker("Hans", "Imgluck", "München", "Hansa@gmail.com",
                "1514344443", "Helper" ,"15.00"),
            ProfileDataSupSeeker("Fritz", "Mayer", "Barcelona", "Fritzi@gmail.com",
                "1514344443", "Window Cleaning" ,"8.00")
                )
    }
    fun getSupportSeeker(){
        var newSupSeekerlist:MutableList<ProfileDataSupSeeker>
    }
}