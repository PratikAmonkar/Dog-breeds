package com.example.dogsbreeds.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dogsbreeds.R

@Composable
fun DisplayDogBreed() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog_img),
            contentDescription = "dog image"
        )
        Text(text = ("Australian Cattle Dog"))
        Text("Hound")

    }
}