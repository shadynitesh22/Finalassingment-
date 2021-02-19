package com.example.finalassingment.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Post (
val PostRating: String? =null,
val PostName: String? =null,
val PostLocation: String? =null,
val PostLikes: String? =null,
val PostImg: String? =null,
val PostPrice: String? =null

){
    @PrimaryKey(autoGenerate = true)
    var postid:Int=0
}


