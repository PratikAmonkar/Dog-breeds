package com.example.dogsbreeds.state

import androidx.lifecycle.ViewModel
import com.example.dogbreeds.repositories.UserRepository

class SignupScreenViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {}