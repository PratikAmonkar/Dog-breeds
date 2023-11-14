package com.example.dogsbreeds.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val userId: String,
    val userName: String,
    val userFullName: String,
    var userPassword: String,
    val isLogin: Boolean,
)