package com.example.quicksuppotapp.data

import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker

class RepositorySupSeeker {
    fun loadSupportSeeker(): MutableList<ProfileDataSupSeeker>{
        return mutableListOf(
                ProfileDataSupSeeker("Ulrich", "Mueller", "Berlin", "ulrich.man1@gmail.com",
                    "1514344443", "Gardening" ,"12.002"),
            ProfileDataSupSeeker("Ulrich", "Mueller", "Berlin", "ulrich.man1@gmail.com",
                "1514344443", "Gardening" ,"12.00,2"),
            ProfileDataSupSeeker("Ulrich", "Mueller", "Berlin", "ulrich.man1@gmail.com",
                "1514344443", "Gardening" ,"12.00,2"),
            ProfileDataSupSeeker("Ulrich", "Mueller", "Berlin", "ulrich.man1@gmail.com",
                "1514344443", "Gardening" ,"12.00,2"),
            ProfileDataSupSeeker("Ulrich", "Mueller", "Berlin", "ulrich.man1@gmail.com",
                "1514344443", "Gardening" ,"12.00,2"),
            ProfileDataSupSeeker("Ulrich", "Mueller", "Berlin", "ulrich.man1@gmail.com",
                "1514344443", "Gardening" ,"12.00,2"),
            ProfileDataSupSeeker("Ulrich", "Mueller", "Berlin", "ulrich.man1@gmail.com",
                "1514344443", "Gardening" ,"12.00,2")
                )
    }
    fun getSupportSeeker(){
        var newSupSeekerlist:MutableList<ProfileDataSupSeeker>
    }
}