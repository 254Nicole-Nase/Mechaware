package com.example.mechaware.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ForumPlaceholderScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Forum Coming Soon", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This feature is under development. Stay tuned!")
    }
}

@Preview
@Composable
fun ForumPlaceholderScreenPreview() {
    ForumPlaceholderScreen()
}
