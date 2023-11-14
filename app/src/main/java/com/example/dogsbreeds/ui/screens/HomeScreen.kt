package com.example.dogsbreeds.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dogsbreeds.provider.AppViewModelProvider
import com.example.dogsbreeds.state.HomeScreenViewModel
import com.example.dogsbreeds.state.HomeUiState
import com.example.dogsbreeds.ui.composables.AppBar
import com.example.dogsbreeds.ui.composables.DisplayDogBreed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navigateToDetailScreen: (String) -> Unit,
) {
    val homeUiState by viewModel.dogState.collectAsState()


    when (homeUiState) {
        is HomeUiState.Loading -> {
            LoadingScreen()
        }

        is HomeUiState.Error -> {
            ErrorScreen(
                action = {
                    viewModel.getDogsBreeds()
                }
            )
        }

        else -> {
            val successState = homeUiState as HomeUiState.Success

            Scaffold(topBar = {
                AppBar(title = "Username")
            }) {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .verticalScroll(rememberScrollState())
                ) {
                    successState.listData.forEachIndexed { index, item ->
                        DisplayDogBreed(
                            navigateToDetailScreen = {
                                navigateToDetailScreen(item.reference_image_id)
                            }, data = item, index = index
                        )
                    }
                }
            }
        }
    }
}