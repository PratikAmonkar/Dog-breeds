package com.example.dogsbreeds.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dogsbreeds.DogBreedsApplication
import com.example.dogsbreeds.state.SignupScreenViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            SignupScreenViewModel(
                inventoryApplication().container.userRepository,
            )
        }
    }
}

fun CreationExtras.inventoryApplication(): DogBreedsApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DogBreedsApplication)