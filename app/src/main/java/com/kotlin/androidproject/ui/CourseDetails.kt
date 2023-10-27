package com.kotlin.androidproject.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kotlin.androidproject.data.Course

@Composable
fun CourseDetails(course: Course){
    Column {

    }
}

@Composable
@Preview
fun previewDetails(){
    CourseDetails(Course("GeeksForGeeks","SelfPaces",33,
        "Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level."))

}