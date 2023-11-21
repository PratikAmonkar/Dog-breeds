package com.example.dogsbreeds.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dogsbreeds.models.DogBreed
import com.example.dogsbreeds.ui.composables.AppBar
import com.example.dogsbreeds.ui.composables.DisplayDogBreed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    data: List<DogBreed>,
    navigateToDetailScreen: (String) -> Unit,
) {

//
//
//    when (homeUiState) {
//        is HomeUiState.Loading -> {
//            LoadingScreen()
//        }
//
//        is HomeUiState.Error -> {
//            ErrorScreen(action = {
//                viewModel.getDogsBreeds()
//            })
//        }
//
//        else -> {
//            val successState = homeUiState as HomeUiState.Success

    Scaffold(topBar = {
        AppBar(
            title = "Username",
            showNavIcon = false,
            popNavigation = {},
            showActionButton = false,
            action = {},
        )
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            data.forEachIndexed { index, item ->
                DisplayDogBreed(
                    navigateToDetailScreen = {
                        navigateToDetailScreen(item.reference_image_id)
                    }, data = item, index = index + 1
                )
            }
        }
    }
}
//}
//}