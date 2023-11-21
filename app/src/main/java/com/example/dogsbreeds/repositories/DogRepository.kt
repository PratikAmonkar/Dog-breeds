package com.example.dogsbreeds.repositories

import com.example.dogsbreeds.models.DogBreed
import com.example.dogsbreeds.models.DogImage
import com.example.dogsbreeds.network.DogApiService
import retrofit2.Response
import retrofit2.http.Path
import javax.inject.Inject

interface DogRepository {
    suspend fun getAllDogsBreed(): Response<List<DogBreed>>
    suspend fun getAllDogsBreedDetails(@Path("imageId") imageId: String): Response<DogImage>

}

class FetchDogRepository @Inject constructor(private val dogApiService: DogApiService) :
    DogRepository {
    override suspend fun getAllDogsBreed(): Response<List<DogBreed>> =
        dogApiService.getAllDogsBreed()

    override suspend fun getAllDogsBreedDetails(imageId: String): Response<DogImage> =
        dogApiService.getAllDogsBreedDetails(imageId)
}