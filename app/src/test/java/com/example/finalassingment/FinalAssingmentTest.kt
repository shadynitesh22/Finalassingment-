package com.example.finalassingment

import com.example.finalassingment.API.ServiceBuilder
import com.example.finalassingment.Model.Post
import com.example.finalassingment.Model.User
import com.example.finalassingment.repository.RepoAddPost
import com.example.finalassingment.repository.RepoUser
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class FinalAssingmentTest {
    private lateinit var userRepository: RepoUser
    private lateinit var studentRepository: RepoAddPost
    // -----------------------------User Testing-----------------------------
    @Test
    fun checkLogin() = runBlocking {
        userRepository = RepoUser()
        val response = userRepository.loginUser("kiran", "kiran123")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun registerUser() = runBlocking {
        val user =
                User(username = "test",email = "test", phone = "zxxcxcx", pass = "testpassword")
        userRepository = RepoUser()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    // -----------------------------Post Testing-----------------------------
    @Test
    fun addStudent() = runBlocking {
        userRepository = RepoUser()
        studentRepository = RepoAddPost()
        val student =
                Post( PostName= "fullName", PostLocation= "Dhapasi", PostPrice = "19000", PostStatus = "address")
        ServiceBuilder.token ="Bearer " + userRepository.loginUser("kiran","kiran123").token
        val expectedResult = true
        val actualResult = studentRepository.addPost(student).success
        Assert.assertEquals(expectedResult, actualResult)
    }
}
