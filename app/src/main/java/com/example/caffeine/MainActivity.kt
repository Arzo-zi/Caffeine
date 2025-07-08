package com.example.caffeine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.caffeine.presentation.navigation.CaffeineNavHost
import com.example.caffeine.presentation.navigation.Screen
import com.example.caffeine.ui.theme.CaffeineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaffeineTheme {
                val navController = rememberNavController()
//                CaffeineNavHost(
//                    navController = navController,
//                    startDestination = Route.OnboardingScreen.route
//                )
                CaffeineNavHost(
                    navController = navController,
                    startDestination = Screen.OnboardingScreen.route
                )
            }
        }
    }
}

//AppContent(
//                    navController = navController
//                )
