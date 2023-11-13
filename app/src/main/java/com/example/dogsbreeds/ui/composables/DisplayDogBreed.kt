package com.example.dogsbreeds.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogsbreeds.R

@Composable
fun DisplayDogBreed() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(color = Color.LightGray, shape = RoundedCornerShape(20.dp))
            .padding(10.dp)
    ) {
        Column(
        ) {
            Image(
                painter = painterResource(id = R.drawable.dog_img),
                contentDescription = "dog image",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))

            )
            Text(
                text = ("Australian Cattle Dog"),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                "Hound", style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.W500
                )
            )

        }
    }
}