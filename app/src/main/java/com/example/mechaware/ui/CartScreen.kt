package com.example.mechaware.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun CartScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Shopping Cart", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        // Placeholder for cart items
        Text(text = "Item 1 - Car Battery")
        Text(text = "Item 2 - Engine Oil")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Handle checkout */ }) {
            Text("Proceed to Checkout")
        }
    }
}

@Preview
@Composable
fun CartScreenPreview() {
    CartScreen(navController = rememberNavController())
}
