package com.example.dogsbreeds.di

import com.example.dogsbreeds.repositories.DogRepository
import com.example.dogsbreeds.repositories.FetchDogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsMyRepository(
        dogRepository: FetchDogRepository
    ): DogRepository
}