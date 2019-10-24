package com.yoggsoggot.testapplication

import androidx.lifecycle.LiveData
import com.yoggsoggot.testapplication.db.User
import com.yoggsoggot.testapplication.db.UserDao

class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insert(user: User){
        userDao.insert(user)
    }
}