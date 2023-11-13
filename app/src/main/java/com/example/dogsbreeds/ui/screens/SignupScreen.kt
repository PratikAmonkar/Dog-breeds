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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dogsbreeds.R
import com.example.dogsbreeds.ui.composables.AlertBox
import com.example.dogsbreeds.ui.composables.AppBar
import com.example.dogsbreeds.ui.composables.CustomButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {

    var userName by rememberSaveable {
        mutableStateOf("")
    }
    var userPassword by rememberSaveable {
        mutableStateOf("")
    }

    var userFullName by rememberSaveable {
        mutableStateOf("")
    }

    var showAlertBox by remember {
        mutableStateOf(false)
    }


    Scaffold(topBar = {
        AppBar(title = "Signup")
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
//                .verticalScroll(
////                    rememberScrollState(),
//
//                    ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.signup_img),
                contentDescription = "Login image"
            )
            OutlinedTextField(
                value = userFullName,
                onValueChange = { value ->
                    userFullName = value
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            OutlinedTextField(
                value = userName,
                onValueChange = { value ->
                    userName = value
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

            CustomButton(title = "Register", action = {
                showAlertBox = true
            })
            if (showAlertBox) {
                AlertBox(
                    confirmAction = {},
                    dismissAction = {
                        showAlertBox = false
                    },
                    status = "Warning",
                    title = "Some fields are empty"
                )
            }
            Text("OR")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            )
            {
                Text("Already have an account ? ")
                Text("Login ")
            }



        }
    }
}