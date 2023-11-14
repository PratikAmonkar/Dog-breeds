package com.example.dogsbreeds.container

import android.content.Context
import com.example.dogsbreeds.database.DogsBreedsDatabase
import com.example.dogbreeds.repositories.OfflineUserRepository
import com.example.dogbreeds.repositories.UserRepository

interface AppContainer {
    val userRepository: UserRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(DogsBreedsDatabase.getDatabase(context).userDao())
    }


}