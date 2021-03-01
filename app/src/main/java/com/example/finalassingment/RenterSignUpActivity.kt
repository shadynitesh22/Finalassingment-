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
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        username = findViewById(R.id.username1)
        email = findViewById(R.id.email1)
        phone = findViewById(R.id.phone1)
        pass = findViewById(R.id.pass1)
        cpass = findViewById(R.id.repass)
        signup = findViewById(R.id.signup1)
        login = findViewById(R.id.login1)
        login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        signup.setOnClickListener {
            val usernamez = username.text.toString()
            val emailz = email.text.toString()
            val phonez = phone.text.toString()
            val passz = pass.text.toString()
            val cpassz = cpass.text.toString()
            if (passz != cpassz) {
                pass.error = "Passwords Don't Match"
                pass.requestFocus()
                return@setOnClickListener
            } else {


                Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show()
                username.setText("")
                email.setText("")
                phone.setText("")
                pass.setText("")
                cpass.setText("")


                val user =
                        User(username = usernamez, email = emailz, phone = phonez, pass = passz)
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val userRepository = RepoUser()
                        val response = userRepository.registerUser(user)
                        if (response.success == true) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                        this@RenterSignUpActivity,
                                        "Register bhayo", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                    this@RenterSignUpActivity,
                                    ex.toString(), Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }


            }
        }
    }
}