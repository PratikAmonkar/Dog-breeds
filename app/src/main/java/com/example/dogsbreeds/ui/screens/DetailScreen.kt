package com.example.dogsbreeds.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                contentDescription = "dog image",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))

            )
            Text(
                "Dog name",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Details",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
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
        }
    }
}