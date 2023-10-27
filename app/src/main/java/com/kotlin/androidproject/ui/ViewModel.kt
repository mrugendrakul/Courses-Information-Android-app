package com.kotlin.androidproject.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.kotlin.androidproject.data.Course
import com.kotlin.androidproject.data.dataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(dataUiState())
    val uiState:StateFlow<dataUiState> = _uiState.asStateFlow()
    private fun showToast(context: Context, message:String,course: Course){
        Log.d("cliable",message+course.name)
        Toast.makeText(context,message+ course.name, Toast.LENGTH_SHORT).show()
    }
    fun setCourse(context: Context,course: Course){
        _uiState.value = dataUiState(course)
//        showToast(context,"Course selected",course)
    }


}