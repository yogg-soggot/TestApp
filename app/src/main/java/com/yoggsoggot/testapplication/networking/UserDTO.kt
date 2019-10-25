package com.yoggsoggot.testapplication.networking

data class UserDTO(
   val id:Int,
   val name:String,
   val surname:String,
   val imgurl: String,
   val posts: List<String>
)