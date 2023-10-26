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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotlin.androidproject.R
import com.kotlin.androidproject.data.dummyData
import com.kotlin.androidproject.data.Course

private fun showToast(context:Context ,message:String){
    Log.d("cliable",message)
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(

){
    val context = LocalContext.current
    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            ),
            modifier = Modifier.fillMaxWidth()
        )}
    ) {
        innerpadding->
        LazyColumn(
            modifier = Modifier.padding(innerpadding)
        ){items(dummyData){
                UserItem(Course = it,modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),onCardClick = { showToast(context,message = "Clicked course is ${it.username}") })
            }

        }

    }
}

@Composable
fun UserItem(Course: Course, modifier: Modifier=Modifier,
             onCardClick : ()->Unit){
    Card(
         modifier.clickable(onClick = onCardClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Column(
//            modifier=modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(Course.username,modifier, textAlign = TextAlign.Center,style = MaterialTheme.typography.titleLarge)
            Text(Course.information,modifier)
            Text(Course.age.toString(),modifier)

        }
    }
}

@Composable
@Preview
fun UserPreview(){
    UserScreen()
}