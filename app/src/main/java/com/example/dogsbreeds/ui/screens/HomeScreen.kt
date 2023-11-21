package com.example.dogsbreeds.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.example.dogsbreeds.models.DogBreed
import com.example.dogsbreeds.state.UiState
import com.example.dogsbreeds.ui.composables.AppBar
import com.example.dogsbreeds.ui.composables.DisplayDogBreed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    data: MutableState<UiState<List<DogBreed>?>>,
    navigateToDetailScreen: (String) -> Unit,
) {
    Scaffold(topBar = {
        AppBar(
            title = "Username",
            showNavIcon = false,
            popNavigation = {},
            showActionButton = false,
            action = {},
        )
    }) {

        when (data.value) {
            is UiState.Loading -> {
                LoadingScreen()
            }

            is UiState.Error -> {
                println("Error")
            }

            else -> {

                Column(
                    modifier = Modifier
                        .padding(it)
                        .verticalScroll(rememberScrollState())
                ) {
                    data.value.data?.forEachIndexed { index, item ->
                        DisplayDogBreed(
                            navigateToDetailScreen = {
                                navigateToDetailScreen(item.reference_image_id)
                            }, data = item, index = index + 1
                        )
                    }
                }
            }
        }


    }
}