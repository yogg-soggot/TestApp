package com.yoggsoggot.testapplication.ui

import android.app.Application
import androidx.lifecycle.*
import com.yoggsoggot.testapplication.UserRepository
import com.yoggsoggot.testapplication.db.User
import com.yoggsoggot.testapplication.db.UserRoomDatabase
import com.yoggsoggot.testapplication.networking.UserDTO
import com.yoggsoggot.testapplication.networking.UserWebRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(application: Application): AndroidViewModel(application){

    private val repository:UserRepository
    val allUsers :LiveData<List<User>>


    val allWebUsers: LiveData<List<UserDTO>>

    val webRepository = UserWebRepository()






    //val allWebUsers: LiveData<List<UserDTO>>

    init {
        val usersDao = UserRoomDatabase.getDatabase(application).userDao()
        repository = UserRepository(usersDao)
        allUsers = repository.allUsers

        allWebUsers = liveData(Dispatchers.IO) {
            val retrievedUsers = webRepository.getAllUsers()

            emit(retrievedUsers)
        }



    }

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }
}