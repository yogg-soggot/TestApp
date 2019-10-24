package com.yoggsoggot.testapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey /*@ColumnInfo(name = "surname")*/ val surname: String,
    /*@ColumnInfo(name = "name")*/val name: String
)