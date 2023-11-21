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

@HiltViewModel
class HiltHomeScreenViewModel @Inject constructor(private val dogRepository: DogRepository) :
    ViewModel() {

    val dogBreedState = mutableStateOf<List<DogBreed>>(emptyList())
    val dogDetailState = mutableStateOf<DogImage?>(null)

    init {
        fetchApiData()
    }

    private fun fetchApiData() {
        viewModelScope.launch {
            val response = dogRepository.getAllDogsBreed()
            if (response.code().toString() == "200") {
                dogBreedState.value = response.body()!!
            }
        }
    }

    fun getDogsBreedDetail(imageId: String) {
        viewModelScope.launch {
            val response = dogRepository.getAllDogsBreedDetails(imageId = imageId)
            if (response.code().toString() == "200") {
                dogDetailState.value = response.body()
            }
//            try {
//                val dogsList = dogRepository.getAllDogsBreedDetails(imageId = imageId)
//                _dogState.value = DetailUiState.Success(listData = dogsList)
//            } catch (e: Exception) {
//                _dogState.value = DetailUiState.Error(errorMessage = "Failed to fetch data")
//            }
        }
    }

}