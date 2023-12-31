package com.example.dogsbreeds.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.dogsbreeds.models.DogImage
import com.example.dogsbreeds.state.UiState
import com.example.dogsbreeds.ui.composables.AppBar
import com.example.dogsbreeds.ui.composables.BreedDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    data: MutableState<UiState<DogImage?>>,
    popNavigation: () -> Unit,
) {
    var isLargeImageVisible by remember { mutableStateOf(false) }

    when (data.value) {
        is UiState.Loading -> {
            LoadingScreen()
        }

        is UiState.Error -> {
            println("Error")
        }

//        else -> {
//
//        }

        else -> {
            data.value.data?.breeds?.forEach { item ->
                Scaffold(topBar = {
                    AppBar(
                        title = item.name,
                        showNavIcon = true,
                        popNavigation = { popNavigation() }, showActionButton = isLargeImageVisible,
                        action = {
                            isLargeImageVisible = false
                        },
                    )
                }) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        Column(
                            modifier = Modifier.verticalScroll(
                                rememberScrollState(),
                            ),
                        ) {
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .wrapContentSize()
                                .clickable {
                                    isLargeImageVisible = true
                                }) {
                                SubcomposeAsyncImage(
                                    model = ImageRequest.Builder(context = LocalContext.current)
                                        .data(data.value.data?.url).crossfade(true).build(),
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
                                    contentScale = ContentScale.Crop,
                                    alignment = Alignment.Center,
                                )
                            }

                            Text(
                                item.name,
                                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                                modifier = Modifier.padding(16.dp)
                            )


                            Text(
                                text = item.description ?: "",
                                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(16.dp)
                            )

                            BreedDetail(
                                attribute = "Breed Group",
                                value = item.breed_group ?: "Unknown",
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
                                value = item.bred_for ?: "Unknown",
                            )
                            BreedDetail(
                                attribute = "Origin",
                                value = item.origin ?: "Unknown",
                            )
                            BreedDetail(
                                attribute = "Country",
                                value = item.country_code ?: "Unknown",
                            )
                        }
                        if (isLargeImageVisible) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        MaterialTheme.colorScheme.primaryContainer.copy(
                                            alpha = 0.9f
                                        )
                                    ), contentAlignment = Alignment.Center
                            ) {
                                SubcomposeAsyncImage(
                                    model = ImageRequest.Builder(context = LocalContext.current)
                                        .data(data.value.data?.url).crossfade(true).build(),
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
                                        .fillMaxSize()
                                        .clip(
                                            RoundedCornerShape(16.dp)
                                        )
                                        .padding(16.dp),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}