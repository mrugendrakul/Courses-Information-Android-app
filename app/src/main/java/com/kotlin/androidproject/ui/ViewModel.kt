package com.kotlin.androidproject.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.kotlin.androidproject.R
import com.kotlin.androidproject.data.Course
import com.kotlin.androidproject.data.dataUiState
//import com.kotlin.androidproject.data.getData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

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

    fun openCourse(context: Context,
                   url:String){
        val intent = Intent(Intent.ACTION_SEND).apply{
            type="text/plain"
            putExtra(Intent.EXTRA_SUBJECT,url)
            putExtra(Intent.EXTRA_TEXT,_uiState.value.selectedCourse.URL)
        }
       context.startActivity(
           Intent.createChooser(
               intent,
               context.getString(R.string.share_course)
           )
       )
        Log.d("ViewModel","shareCourse")
    }

    interface UserService {
        //endPoint to get the data
        @GET("users")
        fun getUsers(): Call<List<Course>>
    }


//jsonParsing(ctx, courseName, courseRequisites, courseImg, courseDesc, courseLink, progress)

    class UserRepository {

        private val retrofit = Retrofit.Builder()
            //Url for the backend data
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val userService = retrofit.create(UserService::class.java)

        fun fetchUsers(callback: (List<Course>?, Throwable?) -> Unit) {
            val call = userService.getUsers()
            call.enqueue(object : Callback<List<Course>> {
                override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                    if (response.isSuccessful) {
                        val users = response.body()
                        callback(users, null) // Success
                    } else {
                        callback(null, Exception("Network request failed"))
                    }
                }

                override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                    callback(null, t) // Failure
                }
            })
        }
    }


    fun getData(){
        val userRep = UserRepository()
        var persons = listOf<Course>()
        userRep.fetchUsers{
                users,error ->
            if(error!=null){
                error.printStackTrace()
            }
            else{
                if (users != null && users.isNotEmpty()) {
                    // Handle the list of users
                    persons = users
                    _uiState.value = dataUiState(dataSet = users)
                    for (user in _uiState.value.dataSet) {
//                    println("Name: ${user.name}, Email: ${user.URL}")
                    Log.d("dataset_viewm","Name: ${user.name}, Email: ${user.URL}")
//                    persons.add(Course(user.name,URL=user.URL))
                    }
                } else {
                    // Handle an empty response
                    println("No users found.")
                }
            }
        }

    }


    init {
        getData()
    }
}