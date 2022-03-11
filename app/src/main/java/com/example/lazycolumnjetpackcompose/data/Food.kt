package com.example.lazycolumnjetpackcompose.data

import java.io.Serializable

data class Food(
    val id: Int,
    val title:String,
    val prize: String,
    val quantity: String,
    val description: String,
    val foodImageId:Int=0
) : Serializable
