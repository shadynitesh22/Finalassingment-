package com.example.finalassingment.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finalassingment.DAO.UserDAO
import com.example.finalassingment.Model.User

@Database(
    entities = [(User::class)],
    version = 1,
    exportSchema = false
)

abstract class UserDb:RoomDatabase() {
    abstract fun getUserDAO(): UserDAO
    companion object {
        @Volatile
        private var instance : UserDb? = null
        fun getInstance(context: Context) : UserDb{
            if(instance == null){
                synchronized(UserDb::class){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        fun buildDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                UserDb::class.java,
                "Userdb"
            ).build()
    }

}