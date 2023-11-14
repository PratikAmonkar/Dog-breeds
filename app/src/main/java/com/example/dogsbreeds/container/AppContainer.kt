package com.example.dogsbreeds.container

import android.content.Context
import com.example.dogsbreeds.database.DogsBreedsDatabase
import com.example.dogsbreeds.network.DogApiService
import com.example.dogsbreeds.repositories.DogRepository
import com.example.dogsbreeds.repositories.FetchDogRepository
import com.example.dogsbreeds.repositories.OfflineUserRepository
import com.example.dogsbreeds.repositories.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val dogRepository: DogRepository
    val userRepository: UserRepository
}

//AppContainer interface which serves as a dependency injection container for the application
class AppDataContainer(private val context: Context) : AppContainer {


//    and retrofit is used to fetch the api from remote api

    private val baseUrl = "https://api.thedogapi.com/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    private val retrofitServiceForDog: DogApiService by lazy {
        retrofit.create(DogApiService::class.java)
    }


    override val dogRepository: DogRepository by lazy {
        FetchDogRepository(retrofitServiceForDog)
    }


    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(DogsBreedsDatabase.getDatabase(context).userDao())
    }
}