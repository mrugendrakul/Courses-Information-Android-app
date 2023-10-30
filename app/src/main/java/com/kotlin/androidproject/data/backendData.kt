package com.kotlin.androidproject.data

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val dummyData = listOf<Course>(Course("hello","he is nice",35),
    Course("Gfg","He is smart",22,"Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level." +
            "Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level." +
            "Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level." +
            "Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level.","www.geeksforgeeks.com"),
    Course("freeCodeCamp"," we are here",21),
    Course("w3School","He can create backend",21),
    Course("w3School","He can create backend",21),
    Course("w3School","He can create backend",21),
    Course("w3School","He can create backend",21),
    Course("w3School","He can create backend",21),
    Course("w3School","He can create backend",21))








