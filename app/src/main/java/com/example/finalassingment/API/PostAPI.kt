package com.example.finalassingment.API

import com.example.finalassingment.Model.Post
import com.example.finalassingment.Response.AddPostResponse
import com.example.finalassingment.Response.DeletePostResponse
import com.example.finalassingment.Response.GetAllPostResponse
import com.example.finalassingment.Response.PostImageResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface PostAPI {
    //Add Student
    @POST("post/")
    suspend fun addPost(
            @Header("Authorization") token: String,
            @Body post: Post
    ): Response<AddPostResponse>

    @GET("post/")
    suspend fun viewPost(
            @Header("Authorization") token: String,
    ): Response<GetAllPostResponse>

    @DELETE("post/{id}")
    suspend fun deletePost(
            @Header("Authorization")token: String,
            @Path("id")id:String
    ): Response<DeletePostResponse>


    @Multipart
    @PUT("post/{id}/photo")
    suspend fun uploadImage(
            @Header("Authorization") token: String,
            @Path("id") id: String,
            @Part file: MultipartBody.Part
    ): Response<PostImageResponse>
}