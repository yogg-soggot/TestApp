package com.yoggsoggot.testapplication

abstract class AbstractUser {
    abstract val id: Int
    abstract val name: String
    abstract val surname: String
    abstract val imgurl: String
    abstract val posts: List<String>
}
