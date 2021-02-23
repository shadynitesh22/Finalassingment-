package com.example.finalassingment.Response

import com.example.finalassingment.Model.User

data class GetAllUserResponse (
    val success: Boolean? =null,
    val count: Int? = null,
    val data: MutableList<User>? = null
        )