package com.example.finalassingment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton

class Splashscreen3 : AppCompatActivity() {
    private lateinit var next:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen3)
        next=findViewById(R.id.next2)
     next.setOnClickListener {
         startActivity(Intent(this,MainActivity::class.java))
     }

    }
}