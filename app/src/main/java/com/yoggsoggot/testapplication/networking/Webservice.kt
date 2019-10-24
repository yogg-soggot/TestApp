package com.yoggsoggot.testapplication.networking


import com.google.gson.GsonBuilder
import com.yoggsoggot.testapplication.db.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {
    @GET("users/{id}")
    suspend fun getUserWithId(@Path("id") userId: Int): UserDTO

    @GET("users")
    suspend fun getAllUsers(): List<UserDTO>

}

