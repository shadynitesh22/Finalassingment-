package com.example.finalassingment.repository

import com.example.finalassingment.API.MyApiRequest
import com.example.finalassingment.API.PostAPI
import com.example.finalassingment.API.ServiceBuilder
import com.example.finalassingment.Model.Post
import com.example.finalassingment.Response.*
import okhttp3.MultipartBody

class RepoAddPost: MyApiRequest() {

    private val postAPI = ServiceBuilder.buildService(PostAPI::class.java)


    //Add Student
    suspend fun addPost(post:Post): AddPostResponse {
        return apiRequest {
            postAPI.addPost(
                    ServiceBuilder.token!!, post
            )
        }
    }

    suspend fun getAllPosts(): GetAllPostResponse {
        return apiRequest {
            postAPI.viewPost(ServiceBuilder.token!!)
        }
    }
    suspend fun deletePosts(id:String): DeletePostResponse {
        return apiRequest {
            postAPI.deletePost(ServiceBuilder.token!!,id)
        }
    }
    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : PostImageResponse {
        return apiRequest {
            postAPI.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }
}