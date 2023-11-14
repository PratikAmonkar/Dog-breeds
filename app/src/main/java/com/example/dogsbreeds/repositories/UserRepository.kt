package com.example.dogbreeds.repositories


import com.example.dogsbreeds.dao.UserDao
import com.example.dogsbreeds.models.User

interface UserRepository {
    suspend fun insert(user: User)
}

class OfflineUserRepository(private val userDao: UserDao) : UserRepository {
    override suspend fun insert(user: User) = userDao.insert(user)
}