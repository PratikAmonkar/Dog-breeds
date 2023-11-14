package com.example.dogsbreeds.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.dogsbreeds.models.DogBreed

@Composable
fun DisplayDogBreed(navigateToDetailScreen: () -> Unit, data: DogBreed, index: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(color = Color.LightGray, shape = RoundedCornerShape(20.dp))
            .padding(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(index.toString())
            Text(
                data.name, modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp)
            )
            IconButton(onClick = {
                navigateToDetailScreen()
            }) {
                Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = "")
            }
        }
    }
}