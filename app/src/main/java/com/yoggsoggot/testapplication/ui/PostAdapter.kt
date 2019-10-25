package com.yoggsoggot.testapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yoggsoggot.testapplication.R

class PostAdapter  internal constructor(context: Context): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var posts = emptyList<String>()

    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val postItemView: TextView = itemView.findViewById(R.id.post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_post_item,parent,false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val current = posts[position]
        holder.postItemView.text = current
    }

    internal fun setPosts(posts: List<String>){
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = posts.size

}