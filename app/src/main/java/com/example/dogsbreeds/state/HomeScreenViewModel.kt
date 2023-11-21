package com.example.dogsbreeds.state


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsbreeds.models.DogBreed
import com.example.dogsbreeds.repositories.DogRepository
import kotlinx.coroutines.launch


sealed interface HomeUiState {
    data class Success(val data: List<DogBreed>?) : HomeUiState
    data class Error(val errorMessage: String) : HomeUiState
    data class Loading(val isLoading: Boolean) : HomeUiState
}

class HomeScreenViewModel(private val dogRepository: DogRepository) : ViewModel() {

//    private val _dogState = MutableStateFlow<HomeUiState>(HomeUiState.Loading(isLoading = true))
//    val dogState: StateFlow<HomeUiState> = _dogState.asStateFlow(
//    ).stateIn(
//        viewModelScope,
//        started = SharingStarted.WhileSubscribed(5000),
//        initialValue = HomeUiState.Loading(isLoading = true)
//    )


     val dogState = mutableStateOf<HomeUiState>(HomeUiState.Loading(isLoading = true))

//    init {
//        getDogsBreeds()
//    }
//    this is coroutine function which get all the dog breeds data

    fun getDogsBreeds() {
        viewModelScope.launch {
            try {
                val response = dogRepository.getAllDogsBreed()

                if (response.code().toString() == "200") {
                    println(response.body())
                    dogState.value = HomeUiState.Success(data = response.body())


//                    val stringDataClass =
//                        HomeUiState.Success<List<DogImage>>(data = response.body())
////                    _dogState.value = response.body()?.let { HomeUiState.Success(data = it) }!!
                } else {
                    dogState.value = HomeUiState.Error(errorMessage = "Something went wrong")

                }
            } catch (e: Exception) {
                dogState.value = HomeUiState.Error(errorMessage = "Failed to fetch data")
            }
        }
    }
}