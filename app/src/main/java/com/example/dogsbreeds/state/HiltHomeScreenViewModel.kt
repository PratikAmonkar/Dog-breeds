package com.example.dogsbreeds.state

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsbreeds.models.DogBreed
import com.example.dogsbreeds.models.DogImage
import com.example.dogsbreeds.repositories.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiState<T>(var data: T? = null, var error: String? = null) {
    class Success<T>(data: T) : UiState<T>(data)
    class Loading<T>() : UiState<T>()
    class Empty<T>() : UiState<T>()
    class Error<T>(error: String?) : UiState<T>(error = error)
}


@HiltViewModel
class HiltHomeScreenViewModel @Inject constructor(private val dogRepository: DogRepository) :
    ViewModel() {

    val dogBreedState = mutableStateOf<UiState<List<DogBreed>?>>(UiState.Empty())

    val dogDetailState = mutableStateOf<UiState<DogImage?>>(UiState.Empty())

    init {
        fetchApiData()
    }

    private fun fetchApiData() {
        dogBreedState.value = UiState.Loading()
        viewModelScope.launch {
            val response = dogRepository.getAllDogsBreed()
            if (response.code().toString() == "200") {
                dogBreedState.value = UiState.Success(data = response.body())
            } else {
                dogBreedState.value = UiState.Error(error = "Something went wrong")
            }
        }
    }

    fun getDogsBreedDetail(imageId: String) {
        dogDetailState.value = UiState.Loading()
        viewModelScope.launch {
            val response = dogRepository.getAllDogsBreedDetails(imageId = imageId)
            if (response.code().toString() == "200") {
                dogDetailState.value = UiState.Success(data = response.body())
            } else {
                dogDetailState.value = UiState.Error(error = "Something went wrong")
            }
        }
//
////        viewModelScope.launch {
////            val response = dogRepository.getAllDogsBreedDetails(imageId = imageId)
////            if (response.code().toString() == "200") {
////                dogDetailState.value = UiState.Success(data = response.body()!!).data
////            }
////        }
    }
}