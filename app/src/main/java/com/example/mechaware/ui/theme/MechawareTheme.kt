package com.example.mechaware.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun MechawareTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = Typography,
        content = content
    )
}

