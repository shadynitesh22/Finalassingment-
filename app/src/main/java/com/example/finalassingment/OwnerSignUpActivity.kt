package com.example.finalassingment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.finalassingment.Model.User
import com.example.finalassingment.repository.RepoUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OwnerSignUpActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var etpass: EditText
    private lateinit var cpass: EditText
    private lateinit var signup: Button
    private lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_sign_up)
        username = findViewById(R.id.username)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
        etpass = findViewById(R.id.pass)
        cpass = findViewById(R.id.cpass)
        signup = findViewById(R.id.signup)
        login = findViewById(R.id.login)
        login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        signup.setOnClickListener {
            val usernamez = username.text.toString()
            val emailz = email.text.toString()
            val phonez = phone.text.toString()
            val passz = etpass.text.toString()
            val cpassz = cpass.text.toString()
            if (passz != cpassz) {
                etpass.error = "Passwords Don't Match"
                etpass.requestFocus()
                return@setOnClickListener
            } else {
                val User = User(username = emailz, email = phonez, phone = passz)
                val user =
                        User(username = usernamez, email = emailz, phone = phonez, password = passz)
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val userRepository = RepoUser()
                        val response = userRepository.registerUser(user)
                        if(response.success == true){
                            withContext(Main) {
                                Toast.makeText(
                                        this@OwnerSignUpActivity,
                                        "Register bhayo", Toast.LENGTH_SHORT
                                ).show()
                                username.setText("")
                                email.setText("")
                                phone.setText("")
                                etpass.setText("")
                                cpass.setText("")
                            }
                        }
                    } catch (ex: Exception) {
                       withContext(Main) {
                            Toast.makeText(
                                    this@OwnerSignUpActivity,
                                    "Error", Toast.LENGTH_SHORT
                            ).show()
                       }
                    }
                }
                // Api code goes here

            }
        }
    }
}