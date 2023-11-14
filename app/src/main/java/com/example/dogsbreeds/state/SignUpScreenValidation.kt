package com.example.dogsbreeds.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsbreeds.repositories.DogRepository
import com.example.dogsbreeds.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class SignUpScreenViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow(
    ).stateIn(
        viewModelScope, started = SharingStarted.WhileSubscribed(5000), initialValue = false
    )

    private val _isError = MutableStateFlow("")

    val isError: StateFlow<String> = _isError.asStateFlow(
    ).stateIn(
        viewModelScope, started = SharingStarted.WhileSubscribed(5000), initialValue = ""
    )

    fun checkEmptyFields(
        userName: String,
        userPassword: String,
        userFullName: String,
        navigateToLoginScreen: () -> Unit,
    ) {
        _isLoading.value = true
        if (userName.isNotEmpty() && userPassword.isNotEmpty() && userFullName.isNotEmpty()) {
            checkPasswordValidation(userPassword = userPassword)
            if (isError.value.isEmpty()) {
                navigateToLoginScreen()
            }

        } else {
            _isLoading.value = false
            _isError.value = "Some fields are empty"

        }
    }

    private fun checkPasswordValidation(userPassword: String) {
        if (userPassword.length < 8) {
            _isError.value = "Password length should be greater then 8 numbers"
        }

        var hasUpperCase = false
        for (char in userPassword) {
            if (char.isUpperCase()) {
                hasUpperCase = true
                break
            }
        }
        if (!hasUpperCase) {
            _isError.value = "Atleast there should one capital letter"
        }

        var hasDigit = false
        for (char in userPassword) {
            if (char.isDigit()) {
                hasDigit = true
                break
            }
        }
        if (!hasDigit) {
            _isError.value = "Atleast there should one digit"
        }

        val specialCharacters =
            setOf('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '=', '_', '+')
        var hasSpecialCharacter = false
        for (char in userPassword) {
            if (specialCharacters.contains(char)) {
                hasSpecialCharacter = true
                break
            }
        }
        if (!hasSpecialCharacter) {
            _isError.value = "Atleast there should one special character"
        }
        _isLoading.value = false
    }

    fun updateErrorState() {
        _isError.value = ""
    }
}