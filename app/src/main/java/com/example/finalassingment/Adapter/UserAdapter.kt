package com.example.finalassingment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassingment.API.ServiceBuilder
import com.example.finalassingment.Model.Post
import com.example.finalassingment.Model.User
import com.example.finalassingment.R

class UserAdapter (
    private val lstStudents:ArrayList<Post>,
    private val context: Context


        ): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
        class UserViewHolder (view:View):RecyclerView.ViewHolder(view){
          val propertyName : TextView = view.findViewById(R.id.postname)
            val propertyPrice :TextView = view.findViewById(R.id.postprice)
            val propertyLocation:TextView= view.findViewById(R.id.postlocation)
            val propertyRating: TextView= view.findViewById(R.id.postrating)
            val propertyLikes:TextView=view.findViewById(R.id.postlikes)
            var photo:ImageView= view.findViewById(R.id.postimg)
            val editpost:ImageButton= view.findViewById(R.id.postedit)
            val addpost:ImageButton= view.findViewById(R.id.postadd)
            val postdel:ImageButton=view.findViewById(R.id.postdel)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapterlayout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val post = lstStudents[position]
        holder.propertyName.text=post.PostName
        holder.propertyPrice.text=post.PostPrice
        holder.propertyLocation.text=post.PostLocation
        val imagePath = ServiceBuilder.loadImagePath() + post.PostImg
        if (!post.PostImg.equals("no-photo.jpg")) {
            Glide.with(context)
                .load(imagePath)
                .fitCenter()
                .into(holder.photo)
        }


    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
