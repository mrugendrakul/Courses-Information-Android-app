package com.kotlin.androidproject.data

data class dataUiState(
    var selectedCourse:Course = Course("","",0),
    var dataSet:List<Course> = listOf()
)