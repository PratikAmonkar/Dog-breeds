package com.example.dogsbreeds.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dogsbreeds.R
import com.example.dogsbreeds.ui.composables.AppBar
import com.example.dogsbreeds.ui.composables.CustomButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    var userEmail by rememberSaveable {
        mutableStateOf("")
    }
    var userPassword by rememberSaveable {
        mutableStateOf("")
    }


    Scaffold(topBar = {
        AppBar(title = "Login")
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState(),

                    ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_img),
                contentDescription = "Login image"
            )
            OutlinedTextField(
                value = userEmail,
                onValueChange = { value ->
                    userEmail = value
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            OutlinedTextField(
                value = userPassword,
                onValueChange = { value ->
                    userPassword = value
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            CustomButton()
            Text("OR")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            )
            {
                Text("Don't have an account ? ")
                Text("Register ")
            }
        }
    }
}