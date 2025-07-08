package com.example.caffeine.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.caffeine.presentation.screen.ChooseCoffeeScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.caffeine.presentation.screen.HomeScreen
import com.example.caffeine.presentation.screen.LoadingHomeScreen
import com.example.caffeine.presentation.screen.OnboardingScreen

@Composable
fun CaffeineNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            modifier = modifier,
            startDestination = startDestination,
            navController = navController
        ) {
            composable(Screen.OnboardingScreen.route) {
                OnboardingScreen(
                    onNavigationToChooseCoffee = {
                        navController.navigate(Screen.ChooseCoffeeScreen.route)
                    }
                )
            }
            composable(Screen.ChooseCoffeeScreen.route) {
                ChooseCoffeeScreen(
                    onNavigateToHomeScreen = {
                        navController.navigate(Screen.HomeScreen.route)
                    }
                )
            }
            composable(Screen.HomeScreen.route) {
                HomeScreen(
                    onNavigateToLoadingScreen = {
                        navController.navigate(Screen.LoadingHomeScreen.route)
                    }
                )
            }
            composable(Screen.LoadingHomeScreen.route) {
                LoadingHomeScreen()
            }
        }
    }
}

//@Composable
//fun CaffeineNavHost(
//    navController: NavHostController,
//    startDestination: Route,
//    modifier: Modifier = Modifier,
//) {
//    CompositionLocalProvider(
//        LocalNavController provides navController
//    ) {
//        NavHost(
//            modifier = modifier,
//            startDestination = startDestination.route,
//            navController = navController
//        ) {
//            composable(Route.OnboardingScreen.route) {
//                OnboardingScreen(
//                    onNavigationToChooseCoffee = {
//                        navController.navigate(Route.ChooseCoffeeScreen.route)
//                    }
//                )
//            }
//
//            composable(Route.ChooseCoffeeScreen.route) {
//                ChooseCoffeeScreen(
//                    onNavigateToHomeScreen = {
//                        navController.navigate(Route.HomeScreen.route)
//                    }
//                )
//            }
//
//            composable(Route.HomeScreen.route) {
//                HomeScreen(
//                    onNavigateToLoadingScreen = {
//                        navController.navigate(Route.LoadingHomeScreen.route)
//                    }
//                )
//            }
//
//            composable(Route.LoadingHomeScreen.route) {
//                LoadingHomeScreen()
//            }
//
////            composable<Route.OnboardingScreen> {
////                OnboardingScreen(
////                    onNavigationToChooseCoffee = {
////                        navController.navigate(
////                            Route.ChooseCoffeeScreen
////                        )
////                    }
////                )
////            }
////
////            composable<Route.ChooseCoffeeScreen> {
////                ChooseCoffeeScreen(
////                    onNavigateToHomeScreen = {
////                        navController.navigate(
////                            Route.HomeScreen
////                        )
////                    }
////                )
////            }
////
////            composable<Route.HomeScreen> {
////                HomeScreen(
////                    onNavigateToLoadingScreen = {
////                        navController.navigate(
////                            Route.LoadingHomeScreen
////                        )
////                    }
////                )
////            }
////
//////            composable<Route.LoadingHomeScreen> {
//////                LoadingHomeScreen()
//////            }
//
//
//        }
//    }
//}
//            composable<Route.OnboardingScreen> {
//                OnboardingScreen()
//            }
//
//            composable<Route.ChooseCoffeeScreen> {
//                ChooseCoffeeScreen(
//
//                )

//composable<Route.HomeScreen> {
//                HomeScreen(
//                    onNavigateToLoadingScreen = {
//                        navController.navigate(Route.LoadingHomeScreen) {
//                            popUpTo(Route.OnboardingScreen) {
//                                inclusive = true
//                            }
//                        }
//                    }
//                )
//            }

