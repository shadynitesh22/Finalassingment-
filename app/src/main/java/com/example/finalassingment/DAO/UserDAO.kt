package com.example.finalassingment.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.finalassingment.Model.User

@Dao
interface UserDAO {
    @Insert
    suspend fun registerUser(User: User)
    @Update
    suspend fun updateUser(User: User)
    @Delete
    suspend fun deleteUser(User: User)
}