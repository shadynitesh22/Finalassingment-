package com.example.finalassingment.Adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalassingment.API.ServiceBuilder
import com.example.finalassingment.Model.Post
import com.example.finalassingment.R
import com.example.finalassingment.repository.RepoAddPost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserAdapter (
    private val lstPosts:ArrayList<Post>,
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
        val post = lstPosts[position]
        holder.propertyName.text=post.PostName
        holder.propertyPrice.text=post.PostPrice
        holder.propertyLocation.text=post.PostLocation
        val imagePath = ServiceBuilder.loadImagePath() + post.photo
        if (!post.photo.equals("no-photo.jpg")) {
            Glide.with(context)
                .load(imagePath)
                .fitCenter()
                .into(holder.photo)
        }
        holder.postdel.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete student")
            builder.setMessage("Are you sure you want to delete ${post.PostName} ??")
            builder.setIcon(android.R.drawable.ic_delete)
            builder.setPositiveButton("Yes") { _, _ ->
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val postRepository = RepoAddPost()
                        val response = postRepository.deletePosts(post._id!!)
                        if (response.success == true) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    context,
                                    "Post Deleted",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            withContext(Dispatchers.Main) {
                                lstPosts.remove(post)
                                notifyDataSetChanged()
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                context,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
            builder.setNegativeButton("No") { _, _ ->
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }


    }

    override fun getItemCount(): Int {
        return lstPosts.size
    }
}


