package com.example.finalassingment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Dashboard2Activity : AppCompatActivity() {
    private lateinit var Addp:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard2)
        Addp =findViewById(R.id.addpost)
        Addp.setOnClickListener {
            startActivity(Intent(this,AddPostActivity::class.java))

        }
    }
}