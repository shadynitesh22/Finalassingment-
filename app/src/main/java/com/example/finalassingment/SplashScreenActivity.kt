package com.example.finalassingment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var next:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        next=findViewById(R.id.next)
        next.setOnClickListener {
            startActivity(Intent(this,Splashscreen2::class.java))
        }




}
}