package com.example.dogsbreeds.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.dogsbreeds.ui.screens.DetailScreen
import com.example.dogsbreeds.ui.screens.HomeScreen
import com.example.dogsbreeds.ui.screens.LoginScreen
import com.example.dogsbreeds.ui.screens.SignUpScreen


@Composable
fun NavigationHost(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController, startDestination = "authentication", modifier = modifier
    ) {
        navigation(startDestination = "signup", route = "authentication") {
            composable(route = "signup") {
                SignUpScreen(navigateToLoginScreen = {
                    navController.navigate("login")
                })
            }
            composable(route = "login") {
                LoginScreen(
                    navigateToSignUpScreen = {
                        navController.navigate("signup")
                    },
                    navigateToMainScreen = {
                        navController.navigate("main-content") {
                            popUpTo(route = "authentication") {
                                inclusive = true
                            }
                        }
                    },
                )
            }
        }

        navigation(startDestination = "home", route = "main-content") {
            composable(route = "home") {
                HomeScreen(navigateToDetailScreen = {
                    navController.navigate("detail/${it}")
                })
            }
            composable(
                route = "detail/{imageId}",
                arguments = listOf(navArgument("imageId") { type = NavType.StringType })
            ) {
                DetailScreen(imageId = it.arguments?.getString("imageId"), popNavigation = {
                    navController.popBackStack()
                })
            }
        }
    }
}