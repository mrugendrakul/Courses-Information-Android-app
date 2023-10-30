package com.kotlin.androidproject.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotlin.androidproject.R
import com.kotlin.androidproject.data.Course

@Composable
fun CourseDetails(course: Course,openCourse:(String)->Unit){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = course.name,
             style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)
        Divider(thickness = 2.dp)
        Row(modifier = Modifier){
            Column (Modifier.weight(1f)){
                Text(text = course.information)
                Divider(thickness = 2.dp)
                Text(text = "${course.age}")
            }
            Spacer(Modifier.weight(1f))
        }
        Divider(thickness = 2.dp, modifier = Modifier.alpha(0f))
        Text(text = course.detailedData,
            style = MaterialTheme.typography.bodyLarge
            )
        Spacer(Modifier.weight(1f))
        Text(text = course.URL)
        Button(onClick = { openCourse(course.URL) },
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(stringResource(R.string.share_this_course))
        }
    }
}

@Composable
@Preview
fun previewDetails(){
    CourseDetails(Course("GeeksForGeeks","SelfPaces",33,
        "Data Structures and Algorithms are building blocks of programming. Data structures enable us to organize and store data, whereas algorithms enable us to process that data in a meaningful sense. So opt for the best quality DSA Course to build & enhance your Data Structures and Algorithms foundational skills and at the same time master them to the next level."),
        openCourse = {})
}