package com.example.dogsbreeds.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BreedDetail(attribute: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(
            attribute,
            modifier = Modifier.weight(1f),
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        )
        Text(
            text = value,
            modifier = Modifier.weight(1f),
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        )
    }
}