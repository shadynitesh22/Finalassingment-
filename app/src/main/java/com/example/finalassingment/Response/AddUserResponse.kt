package com.example.finalassingment.Response

import com.example.finalassingment.Model.Post

data class AddUserResponse (
    val success: Boolean? = null,
    val token: String? = null,
    val data:Post?=null
        )
