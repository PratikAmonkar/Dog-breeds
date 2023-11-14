package com.example.dogsbreeds.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, showNavIcon: Boolean, popNavigation: () -> Unit) {
    TopAppBar(title = {
        Text(text = title, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp))
    }, navigationIcon = {
        if (showNavIcon) {
            IconButton(onClick = {
                popNavigation()
            }) {
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = "back navigation icon"
                )
            }
        }

    })
}