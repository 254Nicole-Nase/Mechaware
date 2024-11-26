package com.example.mechaware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.rememberNavController
import com.example.mechaware.navigation.AppNavigation
import com.example.mechaware.ui.components.BottomBar
import com.example.mechaware.ui.theme.MechawareTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MechawareTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        if (currentRoute(navController) in listOf("home", "search", "cart", "profile")) {
                            BottomBar(navController = navController)
                        }
                    }
                ) { innerPadding ->
                    AppNavigation(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    ) // Manages app navigation
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    MechawareTheme {
        val navController = rememberNavController()
        AppNavigation(navController)
    }
}