package com.example.finalassingment.DAO

import androidx.room.*
import com.example.finalassingment.Model.User

@Dao
interface UserDAO {
    @Insert
    suspend fun registerUser(User: User)
    @Query("select * from User where username=(:username) and pass=(:password)")
    suspend fun checkUser(username: String, password: String): User
    @Update
    suspend fun updateUser(User: User)
    @Delete
    suspend fun deleteUser(User: User)
}