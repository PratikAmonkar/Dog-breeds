package com.example.dogsbreeds.ui.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AlertBox(confirmAction: () -> Unit, dismissAction: () -> Unit, status: String, title: String) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            confirmAction()
        },
        dismissButton = {
            dismissAction()
        },
        title = { Text(text = status) },
        text = { Text(title) },
    )
}