package com.example.dogsbreeds.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.dogsbreeds.R
import com.example.dogsbreeds.ui.composables.AppBar
import com.example.dogsbreeds.ui.composables.BreedDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {
    Scaffold(topBar = {
        AppBar(title = "Dog name")
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(
                    rememberScrollState(),
                ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.dog_img),
                contentDescription = "Dog image",
                modifier = Modifier.fillMaxWidth()
            )
            Text("Dog name")
            Text(text = "Details")
            BreedDetail()
            BreedDetail()
            BreedDetail()
            BreedDetail()
            BreedDetail()
            BreedDetail()
            BreedDetail()
            BreedDetail()
            BreedDetail()
            BreedDetail()
            BreedDetail()
            BreedDetail()
//
//            Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
//                Text("Breed group", modifier = Modifier.weight(1f))
//                Text(text = "Terrier", modifier = Modifier.weight(1f))
//            }
//            Row(modifier = Modifier.fillMaxWidth()) {
//                Text("Breed purpose", modifier = Modifier.weight(1f))
//                Text(text = "Fighting", modifier = Modifier.weight(1f))
//            }
//            Row(modifier = Modifier.fillMaxWidth()) {
//                Text("Average Lifespan", modifier = Modifier.weight(1f))
//                Text(text = "10 - 15 years", modifier = Modifier.weight(1f))
//            }
//            Row(modifier = Modifier.fillMaxWidth()) {
//                Text("Character Traits", modifier = Modifier.weight(1f))
//                Text(
//                    text = "Strong Willed, Stubborn, Friendly, Clownish, Affectionate, Loyal, Obedient, Intelligent, Courageous",
//                    modifier = Modifier.weight(1f)
//                )
//            }
//            Row(modifier = Modifier.fillMaxWidth()) {
//                Text("Average heights", modifier = Modifier.weight(1f))
//                Text(text = "41 - 54", modifier = Modifier.weight(1f))
//            }
//            Row(modifier = Modifier.fillMaxWidth()) {
//                Text("Average width", modifier = Modifier.weight(1f))
//                Text(text = "41 - 54", modifier = Modifier.weight(1f))
//            }
        }
    }
}