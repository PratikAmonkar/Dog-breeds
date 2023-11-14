package com.example.dogsbreeds.container

import android.content.Context
import com.example.dogsbreeds.network.DogApiService
import com.example.dogsbreeds.repositories.DogRepository
import com.example.dogsbreeds.repositories.FetchDogRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val dogRepository: DogRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

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
}