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
                    onNavigateToHomeScreen = { selectedCoffeeType->
                        navController.navigate(Screen.HomeScreen.route){
                            navController.previousBackStackEntry?.savedStateHandle?.set("topBarTitle",selectedCoffeeType)

                        }
                    }
                )
            }
            composable(Screen.HomeScreen.route) { navBackStackEntry->
                val coffeeTypes = navBackStackEntry.savedStateHandle.get<String>("topBarTitle") ?: "home"
                HomeScreen(
                    topBarTitle =coffeeTypes ,
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
