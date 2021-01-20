package com.example.finalassingment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splashscreen2 : AppCompatActivity() {
    private val splastime:Long=3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen2)
        Handler().postDelayed(
            {
                startActivity(Intent(this,Splashscreen3::class.java))
                finish()
            },splastime)
    }
}