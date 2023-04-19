package com.example.quicksuppotapp.data.model

data class ProfileDataSupporter(
    val name:String,
    val surname:String,
    val location:String,
    val email:String,
    val contactno:String,
    val supporttype:String
    ){
    var img:Int?=null
    constructor(
        name: String,
        surname:String,
        location:String,
        email:String,
        contactno:String,
        supporttype:String,
        img : Int) : this(name,surname,location,email,contactno,supporttype) {
        this.img= img
    }
}
