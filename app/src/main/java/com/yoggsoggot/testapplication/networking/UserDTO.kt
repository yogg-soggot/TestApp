package com.yoggsoggot.testapplication.networking

import com.yoggsoggot.testapplication.AbstractUser

data class UserDTO(
   override val id:Int,
   override val name:String,
   override val surname:String,
   override val imgurl: String,
   override val posts: List<String>
):AbstractUser()