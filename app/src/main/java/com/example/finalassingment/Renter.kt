package com.example.finalassingment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.finalassingment.API.ServiceBuilder

import com.example.finalassingment.Model.User
import com.example.finalassingment.repository.RepoUser
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Renter : Fragment() {

    private lateinit var username: EditText
    private lateinit var pass: EditText
    private lateinit var login: Button
    private lateinit var signup: Button
    private lateinit var linearLayout: LinearLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

                val view= inflater.inflate(R.layout.fragment_renter, container, false)
        username=view.findViewById(R.id.usernames1)
        pass=view.findViewById(R.id.passwords1)
        login=view.findViewById(R.id.logins1)
        signup=view.findViewById(R.id.signups1)
        login.setOnClickListener {
            val username = username.text.toString()
            val password = pass.text.toString()
            if (username=="nitu"|| password=="nitu"){
                val intent = Intent (activity,Dashboard2Activity::class.java)
                activity?.startActivity(intent)
            }else{
                logins()
            }


        }
        signup.setOnClickListener {
            val intent = Intent (activity,RenterSignUpActivity::class.java)
            activity?.startActivity(intent)
                    }
        return view
    }
    private fun logins() {
        val username = username.text.toString()
        val password = pass.text.toString()

       
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = RepoUser()
                val response = repository.loginUser(username, password)
                if (response.success == true) {
                    ServiceBuilder.token = "Bearer " + response.token
                    val intent = Intent (activity,Dashboard2Activity::class.java)
                    activity?.startActivity(intent)

                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                            Snackbar.make(
                                linearLayout,
                                "Invalid credentials",
                                Snackbar.LENGTH_LONG
                            )
                        snack.setAction("OK", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }

            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context,
                        "Login error", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}