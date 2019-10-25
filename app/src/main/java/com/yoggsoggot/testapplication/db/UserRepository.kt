package com.yoggsoggot.testapplication.db

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()


    fun loadSingle(id:Int): LiveData<User>{
        return userDao.loadSingle(id)
    }

    suspend fun insert(user: User){
        userDao.insert(user)
    }

    suspend fun insertAll(users:List<User>){
        userDao.insertAll(users)
    }

    suspend fun deleteAll(){
        userDao.deleteAll()
    }
}