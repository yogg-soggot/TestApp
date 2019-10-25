package com.yoggsoggot.testapplication.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yoggsoggot.testapplication.R
import com.yoggsoggot.testapplication.db.User
import com.yoggsoggot.testapplication.ui.user.UserActivity

class UserListAdapter internal constructor(
                context: Context): RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<User>()

    inner class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val nameItemView: TextView = itemView.findViewById(R.id.user_name)
        val surnameItemView: TextView = itemView.findViewById(R.id.user_surname)
        val imageItemView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = users[position]

        val context = holder.itemView.context

        holder.nameItemView.text = current.name
        holder.surnameItemView.text = current.surname

        Glide.with(context)
            .load(current.imgurl)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.imageItemView)


        holder.itemView.setOnClickListener{

            val intent = Intent(context, UserActivity::class.java)
            intent.putExtra("userId",current.id)
            context.startActivity(intent)

        }
    }

    internal fun setUsers(users: List<User>){
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

}