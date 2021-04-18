package com.example.finalassingment.API

import com.example.finalassingment.Model.User
import com.example.finalassingment.Response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserAPI {

    @POST("auth/register")
    suspend fun registerUser(
        @Body user: User
    ): Response<LoginResponse>





    @FormUrlEncoded
    @POST("auth/login")
    suspend fun checkUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<LoginResponse>
}
