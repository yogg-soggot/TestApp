package com.yoggsoggot.testapplication.networking

class UserWebRepository {

    var client: Webservice = RetrofitClient().webservice

    suspend fun getUserWithId(id:Int) = client.getUserWithId(id)

    suspend fun getAllUsers() = client.getAllUsers()
}