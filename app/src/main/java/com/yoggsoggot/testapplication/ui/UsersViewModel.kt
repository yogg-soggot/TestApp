package com.yoggsoggot.testapplication.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.yoggsoggot.testapplication.AbstractUser
import com.yoggsoggot.testapplication.db.UserRepository
import com.yoggsoggot.testapplication.db.User
import com.yoggsoggot.testapplication.db.UserRoomDatabase
import com.yoggsoggot.testapplication.networking.UserDTO
import com.yoggsoggot.testapplication.networking.UserWebRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(application: Application): AndroidViewModel(application){

    private val repository: UserRepository
    val allUsers :LiveData<List<User>>

    private val webRepository = UserWebRepository()
    var allWebUsers: LiveData<List<UserDTO>>



    init {
        val usersDao = UserRoomDatabase.getDatabase(application).userDao()
        repository = UserRepository(usersDao)
        allUsers = repository.allUsers

        allWebUsers = webRepository.getAllUsers()

    }

    fun refresh(){
        allWebUsers = webRepository.getAllUsers()
    }

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun insertAll(users: List<User>) = viewModelScope.launch {
        repository.insertAll(users)
    }
}