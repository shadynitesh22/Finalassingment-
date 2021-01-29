package com.example.finalassingment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class OwnerSignUpActivity : AppCompatActivity() {
    private lateinit var username:EditText
    private lateinit var email:EditText
    private lateinit var phone:EditText
    private lateinit var pass:EditText
    private lateinit var cpass:EditText
    private lateinit var signup:Button
    private lateinit var login:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_sign_up)
        username=findViewById(R.id.username)
        email=findViewById(R.id.email)
        phone=findViewById(R.id.phone)
        pass=findViewById(R.id.pass)
        cpass=findViewById(R.id.cpass)
        signup=findViewById(R.id.signup)
        login=findViewById(R.id.login)
        login.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}