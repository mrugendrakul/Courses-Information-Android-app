package com.kotlin.androidproject.data

data class dataUiState(
    var selectedCourse:Course = Course(),
    var dataSet:List<Course> = listOf(),
    var isInternet:Boolean = true
)