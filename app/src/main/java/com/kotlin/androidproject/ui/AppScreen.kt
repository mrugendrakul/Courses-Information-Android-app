package com.kotlin.androidproject.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kotlin.androidproject.R
import com.kotlin.androidproject.data.dummyData


enum class CourseNav() {
    Courses,
    DeatiledCourse
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(){
    val viewMod : AppViewModel = viewModel()
    val uiState by viewMod.uiState.collectAsState()
    val context = LocalContext.current
    val navController : NavHostController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            ),
            modifier = Modifier.fillMaxWidth()
        )
        }
    ) {
            innerPadding->
        NavHost(navController = navController ,
                startDestination = CourseNav.Courses.name,
                modifier = Modifier.padding(innerPadding)
            ){
            composable(route = CourseNav.Courses.name){

            }
        }


    }
}



@Preview(showSystemUi = true)
@Composable
fun AppPreview(){
    AppScreen()
}