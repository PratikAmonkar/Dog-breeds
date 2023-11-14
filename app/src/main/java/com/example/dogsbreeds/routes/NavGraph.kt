package com.example.dogsbreeds.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dogsbreeds.ui.screens.DetailScreen
import com.example.dogsbreeds.ui.screens.HomeScreen
import com.example.dogsbreeds.ui.screens.LoginScreen
import com.example.dogsbreeds.ui.screens.SignUpScreen


@Composable
fun NavigationHost(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable(route = "signup") {
            SignUpScreen()
        }
        composable(route = "login") {
            LoginScreen()
        }
        composable(route = "home") {
            HomeScreen(
                navigateToDetailScreen = {
                    navController.navigate("detail/${it}")
                }
            )
        }
        composable(
            route = "detail/{imageId}",
            arguments = listOf(navArgument("imageId") { type = NavType.StringType })
        ) {
            DetailScreen(
                imageId = it.arguments?.getString("imageId"),
            )
        }
    }
}