package com.example.dogsbreeds.routes


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.dogsbreeds.state.HiltHomeScreenViewModel
import com.example.dogsbreeds.ui.screens.DetailScreen
import com.example.dogsbreeds.ui.screens.HomeScreen


@Composable
fun NavigationHost(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<HiltHomeScreenViewModel>()

    NavHost(
        navController = navController, startDestination = "main-content", modifier = modifier
    ) {
//        navigation(startDestination = "signup", route = "authentication") {
//            composable(route = "signup") {
//                SignUpScreen(navigateToLoginScreen = {
//                    navController.navigate("login")
//                })
//            }
//            composable(route = "login") {
//                LoginScreen(
//                    navigateToSignUpScreen = {
//                        navController.navigate("signup")
//                    },
//                    navigateToMainScreen = {
//                        navController.navigate("main-content") {
//                            popUpTo(route = "authentication") {
//                                inclusive = true
//                            }
//                        }
//                    },
//                )
//            }
//        }

        navigation(startDestination = "home", route = "main-content") {
            composable(route = "home") {
                HomeScreen(data = viewModel.dogBreedState.value,
                    navigateToDetailScreen = {
                        viewModel.getDogsBreedDetail(imageId = it)
                        navController.navigate("detail")
                    })
            }
            composable(route = "detail") {
                DetailScreen(data = viewModel.dogDetailState.value, popNavigation = {
                    navController.popBackStack()
                })
            }
        }
    }
}