package com.example.dogsbreeds.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.dogsbreeds.provider.AppViewModelProvider
import com.example.dogsbreeds.state.DetailScreenViewModel
import com.example.dogsbreeds.state.DetailUiState
import com.example.dogsbreeds.ui.composables.AppBar
import com.example.dogsbreeds.ui.composables.BreedDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    imageId: String?,
    viewModel: DetailScreenViewModel = viewModel(factory = AppViewModelProvider.Factory),

    ) {
    val detailUiState by viewModel.dogState.collectAsState()

    imageId?.let { viewModel.getDogsBreedDetail(imageId = it) }

    when (detailUiState) {
        is DetailUiState.Loading -> {
            LoadingScreen()
        }

        is DetailUiState.Error -> {
            ErrorScreen(
                action = {
                    if (imageId != null) {
                        viewModel.getDogsBreedDetail(imageId = imageId)
                    }
                }
            )
        }

        else -> {
            val successState = detailUiState as DetailUiState.Success

            successState.listData.breeds.forEach { item ->
                Scaffold(topBar = {
                    AppBar(title = item.name)
                }) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                            .verticalScroll(
                                rememberScrollState(),
                            ),
                    ) {
                        SubcomposeAsyncImage(
                            model = ImageRequest.Builder(context = LocalContext.current)
                                .data(successState.listData.url).crossfade(true).build(),
                            contentDescription = "dog image",
                            loading = {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Box(modifier = Modifier.size(50.dp)) {
                                        CircularProgressIndicator()
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            alignment = Alignment.Center,
                        )
                        Text(
                            item.name,
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = "Details",
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        )
                        BreedDetail(
                            attribute = "Breed Group",
                            value = item.breed_group,
                        )
                        BreedDetail(
                            attribute = "Character Traits",
                            value = item.temperament,
                        )
                        BreedDetail(
                            attribute = "Average Lifespan",
                            value = item.life_span,
                        )
                        BreedDetail(
                            attribute = "Average height",
                            value = item.height.metric,
                        )
                        BreedDetail(
                            attribute = "Average weight",
                            value = item.weight.metric,
                        )
                        BreedDetail(
                            attribute = "Breed Purpose",
                            value = item.bred_for,
                        )
                    }
                }
            }
        }
    }
}