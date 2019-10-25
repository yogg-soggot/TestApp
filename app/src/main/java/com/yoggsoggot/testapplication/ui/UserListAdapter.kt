package com.yoggsoggot.testapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yoggsoggot.testapplication.R
import com.yoggsoggot.testapplication.db.User

class UserListAdapter internal constructor(
                context: Context): RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<User>()

    inner class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val nameItemView: TextView = itemView.findViewById(R.id.name)
        val surnameItemView: TextView = itemView.findViewById(R.id.surname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = users[position]
        holder.nameItemView.text = current.name
        holder.surnameItemView.text = current.surname
    }

    internal fun setUsers(users: List<User>){
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

}