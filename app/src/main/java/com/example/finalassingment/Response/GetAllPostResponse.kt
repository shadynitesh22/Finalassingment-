package com.example.finalassingment.Response

import com.example.finalassingment.Model.Post

data class GetAllPostResponse (
    val success: Boolean? =null,
    val count: Int? = null,
    val data: MutableList<Post>? = null
)