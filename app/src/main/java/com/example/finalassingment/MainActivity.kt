package com.example.finalassingment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var owner:Button
    private lateinit var renter:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        owner=findViewById(R.id.owner)
        renter=findViewById(R.id.renter)
        owner.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container,Owner())
                addToBackStack(null)
                commit()

            }

        }

        renter.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container,Renter())
                addToBackStack(null)
                commit()
            }
        }
    }
}