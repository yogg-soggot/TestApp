package com.yoggsoggot.testapplication.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.yoggsoggot.testapplication.UserRepository
import com.yoggsoggot.testapplication.db.User
import com.yoggsoggot.testapplication.db.UserRoomDatabase
import kotlinx.coroutines.launch

class UsersViewModel(application: Application): AndroidViewModel(application){

    private val repository:UserRepository
    val allUsers :LiveData<List<User>>

    init {
        val usersDao = UserRoomDatabase.getDatabase(application,viewModelScope).userDao()
        repository = UserRepository(usersDao)
        allUsers = repository.allUsers
    }

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }
}