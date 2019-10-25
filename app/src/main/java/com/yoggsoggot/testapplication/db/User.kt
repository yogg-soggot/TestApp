package com.yoggsoggot.testapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yoggsoggot.testapplication.AbstractUser

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    override var id:Int = 0,
    override val surname: String,
    override val name: String,
    override val imgurl: String,
    override val posts: List<String>
): AbstractUser()