package com.example.mechaware.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.mechaware.ui.*

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }

        // Bottom Navigation Bar Screens
        composable("search") { SearchScreen(navController) }
        composable("feedback") { FeedbackScreen() }
        composable("forum") { ForumPlaceholderScreen() }
        composable("profile") { ProfileScreen(navController) } // Profile implementation
        composable("cart") { CartScreen(navController) }

        // Define product_details route with a productId argument
        composable(
            route = "product_details/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            ProductDetailsScreen(productId = productId) // Pass the productId
        }

        composable("register") { RegisterScreen(navController) }
    }
}



