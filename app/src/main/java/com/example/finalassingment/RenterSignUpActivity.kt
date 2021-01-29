package com.example.finalassingment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RenterSignUpActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var pass: EditText
    private lateinit var cpass: EditText
    private lateinit var signup: Button
    private lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_renter_sign_up)
        username=findViewById(R.id.username1)
        email=findViewById(R.id.email1)
        phone=findViewById(R.id.phone1)
        pass=findViewById(R.id.pass1)
        cpass=findViewById(R.id.repass)
        signup=findViewById(R.id.signup1)
        login=findViewById(R.id.login1)
        login.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}