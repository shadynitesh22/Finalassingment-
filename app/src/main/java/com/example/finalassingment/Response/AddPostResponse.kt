package com.example.finalassingment.Response

import com.example.finalassingment.Model.Post
import com.example.finalassingment.Model.User

data class AddPostResponse (
    val success: Boolean? = null,
    val token: String? = null,
    val data:Post?=null
        )
