package com.yoggsoggot.testapplication.networking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserWebRepository {

    var client: Webservice = RetrofitClient().webservice


    fun getAllUsers(): LiveData<List<UserDTO>> {

        val liveData = MutableLiveData<List<UserDTO>>()


        client.getAllUsers().enqueue(object: Callback<List<UserDTO>>{

            override fun onResponse(call: Call<List<UserDTO>>, response: Response<List<UserDTO>>) {
                if(response.isSuccessful){
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<UserDTO>>, t: Throwable) {
                t.printStackTrace()
            }

        })

        return liveData
        }



    }