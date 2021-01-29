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
import android.widget.Toast
import com.example.finalassingment.DB.UserDb
import com.example.finalassingment.Model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Renter : Fragment() {
    val applicationContext: Context
        get() {
            TODO()
        }
    private lateinit var username: EditText
    private lateinit var pass: EditText
    private lateinit var login: Button
    private lateinit var signup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

                val view= inflater.inflate(R.layout.fragment_renter, container, false)
        username=view.findViewById(R.id.usernames1)
        pass=view.findViewById(R.id.passwords1)
        login=view.findViewById(R.id.logins1)
        signup=view.findViewById(R.id.signups1)
        login.setOnClickListener {
            logins()
        }
        signup.setOnClickListener {
            val intent = Intent (getActivity(),RenterSignUpActivity::class.java)
            getActivity()?.startActivity(intent)
                    }
        return view
    }
    private fun logins() {
        val username = username.text.toString()
        val password = pass.text.toString()

        var user: User? = null
        CoroutineScope(Dispatchers.IO).launch {
            user = context?.let {
                UserDb
                    .getInstance(it)
                    .getUserDAO()
                    .checkUser(username, password)
            }
            if (user == null) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                val intent = Intent (getActivity(),Dashboard2Activity::class.java)
                getActivity()?.startActivity(intent)

            }
        }
    }

}