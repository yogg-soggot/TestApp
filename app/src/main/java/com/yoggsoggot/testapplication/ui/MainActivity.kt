package com.yoggsoggot.testapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yoggsoggot.testapplication.R
import com.yoggsoggot.testapplication.db.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var usersViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = UserListAdapter(this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        usersViewModel = ViewModelProvider(this).get(UsersViewModel::class.java)

        usersViewModel.allUsers.observe(this, Observer {users ->
            users?.let { adapter.setUsers(it) }
        })

        button.setOnClickListener{
            usersViewModel.insert(User(0,"Nikita","Ivanov"))
        }

    }
}
