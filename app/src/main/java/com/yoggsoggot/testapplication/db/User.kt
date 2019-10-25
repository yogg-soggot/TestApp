package com.yoggsoggot.testapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    val surname: String,
    val name: String,
    val imgurl: String,
    val posts: String
)