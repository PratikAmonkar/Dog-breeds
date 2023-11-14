package com.example.dogsbreeds.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class LoginScreenViewModel() : ViewModel() {

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

    fun checkEmptyFields(userName: String, userPassword: String, navigateToMainScreen: () -> Unit) {
        _isLoading.value = true
        if (userName.isNotEmpty() && userPassword.isNotEmpty()) {
            _isError.value = ""
            navigateToMainScreen()
        } else {
            _isLoading.value = false
            _isError.value = "Some fields are empty"

        }
    }

    fun updateErrorState() {
        _isError.value = ""
    }


}