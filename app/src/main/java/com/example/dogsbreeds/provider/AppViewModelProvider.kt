package com.example.dogsbreeds.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dogsbreeds.DogsBreedsApplication
import com.example.dogsbreeds.state.DetailScreenViewModel
import com.example.dogsbreeds.state.HomeScreenViewModel
import com.example.dogsbreeds.state.LoginScreenViewModel
import com.example.dogsbreeds.state.SignUpScreenViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeScreenViewModel(
                inventoryApplication().container.dogRepository,
            )
        }
        initializer {
            DetailScreenViewModel(
                inventoryApplication().container.dogRepository,
            )
        }
        initializer {
            SignUpScreenViewModel(
                inventoryApplication().container.userRepository,

                )
        }
        initializer {
            LoginScreenViewModel(
                inventoryApplication().container.userRepository,

                )
        }
    }
}

fun CreationExtras.inventoryApplication(): DogsBreedsApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DogsBreedsApplication)