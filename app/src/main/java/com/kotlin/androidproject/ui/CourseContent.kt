package com.kotlin.androidproject.ui


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kotlin.androidproject.R
import com.kotlin.androidproject.data.dummyData
import com.kotlin.androidproject.data.Course

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen(
    onCardClick: (Course) -> Unit,
    dataSet:List<Course>,
    modifier: Modifier=Modifier,

){
    Column {


        LazyColumn(
            modifier = modifier
        ) {
            items(dataSet) {
                CourseItem(Course = it, modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(), onCardClick = { onCardClick(it) })
            }

        }
//        Text(text = currentCourse)
    }
    }


@Composable
fun CourseItem(Course: Course, modifier: Modifier=Modifier,
             onCardClick : ()->Unit){
    Card(
         modifier.clickable(onClick = onCardClick)
             .clip(MaterialTheme.shapes.medium),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Column(
//            modifier=modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(Course.name,modifier, textAlign = TextAlign.Center,style = MaterialTheme.typography.titleLarge)
            Text("Information : "+Course.information,modifier)
            Text("Time to complete : "+Course.age.toString()+" hrs",modifier)

        }
    }
}

@Composable
@Preview
fun UserPreview(){
    CourseScreen(onCardClick = {}, dataSet= dummyData)
}