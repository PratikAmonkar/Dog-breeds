package com.example.dogsbreeds.network

import com.example.dogsbreeds.models.DogBreed
import com.example.dogsbreeds.models.DogImage
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiService {
    @GET("breeds?limit=20&page=0")
    suspend fun getAllDogsBreed(): List<DogBreed>


    @GET("images/{imageId}")
    suspend fun getAllDogsBreedDetails(@Path("imageId") imageId: String): DogImage


}