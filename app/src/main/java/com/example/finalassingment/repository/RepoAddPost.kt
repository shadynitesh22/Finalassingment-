package com.example.finalassingment.repository

import com.example.finalassingment.API.MyApiRequest
import com.example.finalassingment.API.PostAPI
import com.example.finalassingment.API.ServiceBuilder
import com.example.finalassingment.Model.Post
import com.example.finalassingment.Response.AddPostResponse
import com.example.finalassingment.Response.DeleteResponse
import com.example.finalassingment.Response.GetAllPostResponse
import com.example.finalassingment.Response.ImageResponse
import okhttp3.MultipartBody

class RepoAddPost: MyApiRequest() {

    private val PostAPI = ServiceBuilder.buildService(PostAPI::class.java)

    //Add Student
    suspend fun addStudent(post: Post): AddPostResponse{
        return apiRequest {
            PostAPI.addPost(
                ServiceBuilder.token!!, post
            )
        }
    }

    suspend fun getAllPost(): GetAllPostResponse {
        return apiRequest {
            PostAPI.viewPost(ServiceBuilder.token!!)
        }
    }
    suspend fun deletePost(id:String): DeleteResponse {
        return apiRequest {
            PostAPI.deletePost(ServiceBuilder.token!!,id)
        }
    }
    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            studentAPI.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }
}