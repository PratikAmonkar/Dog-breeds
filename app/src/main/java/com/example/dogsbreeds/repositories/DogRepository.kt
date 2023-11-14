package com.example.dogsbreeds.repositories

import com.example.dogsbreeds.models.DogBreed
import com.example.dogsbreeds.models.DogImage
import com.example.dogsbreeds.network.DogApiService
import retrofit2.http.Path

interface DogRepository {
    suspend fun getAllDogsBreed(): List<DogBreed>
    suspend fun getAllDogsBreedDetails(@Path("imageId") imageId: String): DogImage

}

class FetchDogRepository(private val dogApiService: DogApiService) : DogRepository {
    override suspend fun getAllDogsBreed(): List<DogBreed> = dogApiService.getAllDogsBreed()
    override suspend fun getAllDogsBreedDetails(imageId: String): DogImage =
        dogApiService.getAllDogsBreedDetails(imageId)
}