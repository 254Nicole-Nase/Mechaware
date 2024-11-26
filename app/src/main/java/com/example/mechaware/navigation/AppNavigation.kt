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
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) { SplashScreen(navController) }
        composable(Routes.LOGIN) { LoginScreen(navController) }
        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.SEARCH) { SearchScreen(navController, query = "") }
        composable(Routes.FEEDBACK) { FeedbackScreen() }
        composable(Routes.FORUM) { ForumPlaceholderScreen() }
        composable(Routes.PROFILE) { ProfileScreen(navController) }
        composable(Routes.CART) { CartScreen(navController) }
        composable(Routes.REGISTER) { RegisterScreen(navController) }

        // Pass productId as argument for ProductDetailsScreen
        composable(
            route = "product_details/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            if (productId != null) {
                ProductDetailsScreen(productId = productId, navController = navController)
            }
        }
    }
}
