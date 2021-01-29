package com.example.finalassingment.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class User (
    val username:String?=null,
    val email:String?=null,
    val phone:String?=null,
    val pass:String?=null,
    val conf:String?=null

        ){
        @PrimaryKey(autoGenerate = true)
        var userid:Int=0
}
