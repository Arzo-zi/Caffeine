package com.example.caffeine.presentation.navigation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("No NavigationController provided")
}