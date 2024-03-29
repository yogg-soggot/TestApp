package com.yoggsoggot.testapplication.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoggsoggot.testapplication.R
import com.yoggsoggot.testapplication.db.User
import com.yoggsoggot.testapplication.listToJson
import com.yoggsoggot.testapplication.ui.UsersViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var usersViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = UserListAdapter(this)
        recyclerview.adapter = adapter
        val orientation = resources.configuration.orientation
        if(orientation == 1) {
            recyclerview.layoutManager = LinearLayoutManager(this)
        } else recyclerview.layoutManager = GridLayoutManager(this,2)


        usersViewModel = ViewModelProvider(this).get(UsersViewModel::class.java)

        usersViewModel.allUsers.observe(this, Observer {users ->
            users?.let { adapter.setUsers(it) }
        })


       usersViewModel.allWebUsers.observe(this, Observer { users ->

                val usersList = users.map{ User(0, it.surname, it.name,it.imgurl, listToJson(it.posts))}
                Log.w("net",usersList[1].imgurl)
                usersViewModel.deleteAll()
                usersViewModel.insertAll(usersList)

        })



        }

    }

