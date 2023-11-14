package com.example.dogsbreeds.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dogsbreeds.ui.screens.LoginScreen
import com.example.dogsbreeds.ui.screens.SignUpScreen


@Composable
fun NavigationHost(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = "signup", modifier = modifier) {
        composable(route = "signup") {
            SignUpScreen()
        }
        composable(route = "login") {
            LoginScreen()
        }
    }
}