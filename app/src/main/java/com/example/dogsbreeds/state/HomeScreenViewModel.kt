package com.example.dogsbreeds.state


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsbreeds.models.DogBreed
import com.example.dogsbreeds.repositories.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


sealed interface HomeUiState {
    data class Success(val listData: List<DogBreed>) : HomeUiState
    data class Error(val errorMessage: String) : HomeUiState
    data class Loading(val isLoading: Boolean) : HomeUiState
}

class HomeScreenViewModel(private val dogRepository: DogRepository) : ViewModel() {

    private val _dogState = MutableStateFlow<HomeUiState>(HomeUiState.Loading(isLoading = true))
    val dogState: StateFlow<HomeUiState> = _dogState.asStateFlow(
    ).stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeUiState.Loading(isLoading = true)
    )

    init {
        getDogsBreeds()
    }

     fun getDogsBreeds() {
        viewModelScope.launch {
            try {
                val dogsList = dogRepository.getAllDogsBreed()
                _dogState.value = HomeUiState.Success(listData = dogsList)
            } catch (e: Exception) {
                _dogState.value = HomeUiState.Error(errorMessage = "Failed to fetch data")
            }
        }
    }
}