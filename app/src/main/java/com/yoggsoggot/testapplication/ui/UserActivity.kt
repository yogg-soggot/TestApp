package com.yoggsoggot.testapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yoggsoggot.testapplication.R
import com.yoggsoggot.testapplication.toList
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity: AppCompatActivity() {

    private lateinit var usersViewModel: UsersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val userId = intent.getIntExtra("userId",0)





        usersViewModel = ViewModelProvider(this).get(UsersViewModel::class.java)

        val singleUser = usersViewModel.loadSingle(userId)

        singleUser.observe(this, Observer { user ->
            user_name.text = user.name
            user_surname.text = user.surname

            Glide.with(this)
                .load(user.imgurl)
                .apply(RequestOptions.circleCropTransform())
                .into(user_image_view)

            val posts = toList(user.posts)
        })


    }


}