package com.example.myapplication

import com.google.firebase.database.Exclude

data class Img(
    var name:String? = null,
    var imageUrl:String? = null,
    var description:String? = null,
    var verson:String? = null,
    @get:Exclude
    @set:Exclude
    var key:String? = null )
