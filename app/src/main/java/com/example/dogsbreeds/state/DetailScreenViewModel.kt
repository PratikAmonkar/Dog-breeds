package com.example.dogsbreeds.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsbreeds.models.DogImage
import com.example.dogsbreeds.repositories.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

sealed interface DetailUiState {
    data class Success(val listData: DogImage) : DetailUiState
    data class Error(val errorMessage: String) : DetailUiState
    data class Loading(val isLoading: Boolean) : DetailUiState
}

class DetailScreenViewModel(private val dogRepository: DogRepository) : ViewModel() {

    private val _dogState = MutableStateFlow<DetailUiState>(DetailUiState.Loading(isLoading = true))
    val dogState: StateFlow<DetailUiState> = _dogState.asStateFlow(
    ).stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DetailUiState.Loading(isLoading = true)
    )

//    this coroutine function which get all the details of dog breed based on specific image id
//    fun getDogsBreedDetail(imageId: String) {
//        viewModelScope.launch {
//            try {
//                val dogsList = dogRepository.getAllDogsBreedDetails(imageId = imageId)
//                _dogState.value = DetailUiState.Success(listData = dogsList)
//            } catch (e: Exception) {
//                _dogState.value = DetailUiState.Error(errorMessage = "Failed to fetch data")
//            }
//        }
//    }
}