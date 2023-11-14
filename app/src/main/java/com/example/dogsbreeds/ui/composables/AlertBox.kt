package com.example.dogsbreeds.ui.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AlertBox(confirmAction: () -> Unit, dismissAction: () -> Unit, status: String, title: String) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Button(onClick = {confirmAction()}) {
                Text("Ok")
            }
        },
        dismissButton = {
            Button(onClick = {dismissAction()}) {
                Text("Cancel")
            }        },
        title = { Text(text = status) },
        text = { Text(title) },
    )
}