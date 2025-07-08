package com.example.caffeine.presentation.navigation


sealed class Screen(val route: String) {
    data object OnboardingScreen : Screen("onboarding")
    data object ChooseCoffeeScreen : Screen("choose_coffee")
    data object HomeScreen : Screen("home")
    data object LoadingHomeScreen : Screen("loading_home")

}

//sealed interface Route {
//    val route: String
//    @Serializable
//    data object OnboardingScreen : Route {
//        override val route = "onboarding"
//    }
//    @Serializable
//    data object ChooseCoffeeScreen : Route {
//        override val route = "choose_coffee"
//    }
//    @Serializable
//    data object HomeScreen : Route {
//        override val route = "home"
//    }
//    @Serializable
//    data object LoadingHomeScreen : Route {
//        override val route = "loading_home"
//    }
//}

//sealed interface Route {
//
//    @Serializable
//    data object OnboardingScreen : Route
//
//    @Serializable
//    data object ChooseCoffeeScreen : Route
//
//    @Serializable
//    data object HomeScreen : Route
//
//    @Serializable
//    data object LoadingHomeScreen : Route
//
//}

//sealed class Route(val route: String) {
//    @Serializable
//    data object OnboardingScreen : Route("onboarding")
//    @Serializable
//    data object ChooseCoffeeScreen : Route("choose_coffee")
//    @Serializable
//    data object HomeScreen : Route("home")
//    @Serializable
//    data object LoadingHomeScreen : Route("loading_home")
//}

//
//sealed interface Screen {
//
//    data object OnboardingScreen : Screen
//
//    data object ChooseCoffeeScreen : Screen
//
//    data object HomeScreen : Screen
//
//    data object LoadingHomeScreen : Screen
//}