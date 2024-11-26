package com.example.mechaware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.mechaware.navigation.AppNavigation
import com.example.mechaware.ui.theme.MechawareTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MechawareTheme {
                val navController = rememberNavController()
                AppNavigation(navController) // Manages app navigation
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