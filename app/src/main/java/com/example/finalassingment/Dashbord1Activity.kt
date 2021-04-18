package com.example.finalassingment

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassingment.Adapter.UserAdapter
import com.example.finalassingment.Model.Post
import com.example.finalassingment.repository.RepoAddPost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Dashbord1Activity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val permissions = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbord1)
        if (!hasPermission()) {
            requestPermission()
        }
        recyclerView = findViewById(R.id.recyclerview)
        loadPost()
    }

    private fun loadPost() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val postRepository = RepoAddPost()
                val response = postRepository.getAllPosts()
                if(response.success==true){
                    // Put all the student details in lstStudents
                    val lstStudents = response.data
                    withContext(Dispatchers.Main){
                        val adapter = UserAdapter(lstStudents as ArrayList<Post>, this@Dashbord1Activity)
                        recyclerView.layoutManager = LinearLayoutManager(this@Dashbord1Activity)
                        recyclerView.adapter = adapter
                    }
                }
            }catch(ex : Exception){
               // withContext(Dispatchers.Main){
                 //   Toast.makeText(this@Dashbord1Activity,
                   //         "Error : ${ex.toString()}", Toast.LENGTH_SHORT).show()
                //}
            }
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this@Dashbord1Activity,
            permissions, 1
        )
    }
    private fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
            }
        }
        return hasPermission
    }
}