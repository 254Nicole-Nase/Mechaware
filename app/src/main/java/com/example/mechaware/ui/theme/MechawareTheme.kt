package com.example.mechaware.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MechawareTheme(content: @Composable () -> Unit) {
    val colorScheme = darkColorScheme(
        primary = Color(0xFF37474F),  // Metallic blue-grey
        secondary = Color(0xFFD32F2F),  // Red accent
        surface = Color(0xFF212121),   // Dark grey
        onPrimary = Color.White
    )
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

