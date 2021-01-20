package com.example.finalassingment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splashscreen3 : AppCompatActivity() {
    private val splastime:Long=5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen3)
        Handler().postDelayed(
            {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },splastime)
    }
}