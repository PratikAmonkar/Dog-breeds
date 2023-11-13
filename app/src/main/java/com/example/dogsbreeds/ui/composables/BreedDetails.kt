package com.example.dogsbreeds.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BreedDetail() {
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("Breed group", modifier = Modifier.weight(1f))
        Text(text = "Terrier", modifier = Modifier.weight(1f))
    }
}