package com.example.dogsbreeds.ui.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomButton(title:String) {
    Button(onClick = {}) {
        Text(title)
    }
}


