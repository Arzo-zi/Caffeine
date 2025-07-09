package com.example.caffeine.presentation.navigation


sealed class Screen(val route: String) {
    data object OnboardingScreen : Screen("onboarding")
    data object ChooseCoffeeScreen : Screen("choose_coffee")
    data object HomeScreen : Screen("home/{coffeeTypes}")
    data object LoadingHomeScreen : Screen("loading_home")

}
