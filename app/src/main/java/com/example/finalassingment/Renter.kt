package com.example.finalassingment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class Renter : Fragment() {
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
        signup.setOnClickListener {
            val intent = Intent (getActivity(),RenterSignUpActivity::class.java)
            getActivity()?.startActivity(intent)
                    }
        return view
    }

}