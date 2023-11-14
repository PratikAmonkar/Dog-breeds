package com.example.dogsbreeds.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dogsbreeds.R
import com.example.dogsbreeds.provider.AppViewModelProvider
import com.example.dogsbreeds.state.SignUpScreenViewModel
import com.example.dogsbreeds.ui.composables.AlertBox
import com.example.dogsbreeds.ui.composables.AppBar
import com.example.dogsbreeds.ui.composables.CustomButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpScreenViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navigateToLoginScreen: () -> Unit

) {
    val errorState by viewModel.isError.collectAsState()
    val loadingState by viewModel.isLoading.collectAsState()


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
        AppBar(
            title = "Signup", showNavIcon = false, popNavigation = {}, showActionButton = false,
            action = {},
        )
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
                painter = painterResource(id = R.drawable.signup_img),
                contentDescription = "Login image",
                modifier = Modifier.size(300.dp)
            )
            OutlinedTextField(
                value = userFullName,
                onValueChange = { value ->
                    userFullName = value
                },
                placeholder = {
                    Text(
                        "Enter username",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W500)
                    )
                },
                textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W500),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Person icon")
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {}),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )
            OutlinedTextField(
                value = userName,
                onValueChange = { value ->
                    userName = value
                },
                placeholder = {
                    Text(
                        "Enter full name",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W500)
                    )
                },
                textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W500),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Person icon")
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {}),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )
            OutlinedTextField(
                value = userPassword,
                onValueChange = { value ->
                    userPassword = value
                },
                placeholder = {
                    Text(
                        "Enter password",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W500)
                    )
                },
                textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W500),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "Password icon")
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {}),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )

            if (loadingState) {
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                CustomButton(title = "Register", action = {
                    viewModel.checkEmptyFields(
                        userName = userName,
                        userPassword = userPassword,
                        userFullName = userFullName,
                        navigateToLoginScreen = {navigateToLoginScreen()}
                    )
                })
            }

            if (errorState.isNotEmpty()) {
                AlertBox(confirmAction = {}, dismissAction = {
                    viewModel.updateErrorState()
                }, status = "Warning", title = errorState
                )
            }
            Text("OR", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W400))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Already have an account ? ",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W400)
                )
                Text("Login ",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W400),
                    modifier = Modifier.clickable { navigateToLoginScreen() })
            }
        }
    }
}