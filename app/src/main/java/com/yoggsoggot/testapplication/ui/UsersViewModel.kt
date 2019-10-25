package com.yoggsoggot.testapplication.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.yoggsoggot.testapplication.db.User
import com.yoggsoggot.testapplication.db.UserRepository
import com.yoggsoggot.testapplication.db.UserRoomDatabase
import com.yoggsoggot.testapplication.networking.UserDTO
import com.yoggsoggot.testapplication.networking.UserWebRepository
import kotlinx.coroutines.launch

class UsersViewModel(application: Application): AndroidViewModel(application){

    private val repository: UserRepository
    val allUsers: LiveData<List<User>>


    private val webRepository = UserWebRepository()
    val allWebUsers: LiveData<List<UserDTO>>



    init {
        val usersDao = UserRoomDatabase.getDatabase(application).userDao()
        repository = UserRepository(usersDao)
        allUsers = repository.allUsers

        allWebUsers = webRepository.getAllUsers()

    }


    fun loadSingle(id:Int): LiveData<User>{
        return repository.loadSingle(id)
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