package com.yoggsoggot.testapplication


import com.google.gson.Gson


    fun toList(s:String?): List<String>?{
        if(s == null){
            return null
        }
        return Gson().fromJson(s, Array<String>::class.java).asList()
    }


    fun listToJson(list: List<String>):String {
        return Gson().toJson(list)
    }
