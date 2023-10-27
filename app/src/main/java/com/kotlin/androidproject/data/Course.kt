package com.kotlin.androidproject.data

data class Course(
    val name:String,
    val information:String,
    val age:Int,
    val detailedData:String = "",
    val URL:String = "www.google.com"
)
