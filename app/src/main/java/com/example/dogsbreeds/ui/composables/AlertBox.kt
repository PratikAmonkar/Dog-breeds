package com.example.dogsbreeds.ui.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AlertBox( dismissAction: () -> Unit, status: String, title: String) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Button(onClick = { dismissAction() }) {
                Text("Ok")
            }
        },
        title = { Text(text = status, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) },
        text = { Text(title) },
    )
}