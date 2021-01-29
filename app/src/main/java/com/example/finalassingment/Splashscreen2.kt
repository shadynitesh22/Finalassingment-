package com.example.finalassingment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton

class Splashscreen2 : AppCompatActivity() {

    private lateinit var next:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen2)
        next=findViewById(R.id.next1)
        next.setOnClickListener {
            startActivity(Intent(this,Splashscreen3::class.java))
        }

    }
}