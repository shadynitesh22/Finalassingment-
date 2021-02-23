package com.example.finalassingment.repository

import com.example.finalassingment.API.MyApiRequest
import com.example.finalassingment.API.ServiceBuilder
import com.example.finalassingment.API.UserAPI
import com.example.finalassingment.Model.User
import com.example.finalassingment.Response.LoginResponse

class RepoUser: MyApiRequest(){
    private val userAPI = ServiceBuilder.buildService(UserAPI::class.java)

    //Register User
    suspend fun registerUser(user: User): LoginResponse {
        return apiRequest {
            userAPI.registerUser(user)
        }
    }

    //Login User
    suspend fun loginUser(username: String, password:String): LoginResponse{
        return  apiRequest {
            userAPI.checkUser(username,password)
        }
    }
}
