package com.example.mechaware.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mechaware.models.Product
import com.google.firebase.database.FirebaseDatabase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(productId: String?) {
    // State variables to hold product data and error messages
    var product by remember { mutableStateOf<Product?>(null) }
    var errorMessage by remember { mutableStateOf("") }

    // Fetch product details from Firebase when productId is provided
    if (!productId.isNullOrEmpty()) {
        LaunchedEffect(productId) {
            val database = FirebaseDatabase.getInstance()
            val productRef = database.getReference("products/$productId")

            productRef.get()
                .addOnSuccessListener { snapshot ->
                    product = snapshot.getValue(Product::class.java)
                }
                .addOnFailureListener {
                    errorMessage = it.localizedMessage ?: "Failed to load product"
                }
        }
    }

    // UI Layout
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Product Details") }) }
    ) { innerPadding ->
        when {
            product == null && errorMessage.isEmpty() -> {
                // Loading State
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            errorMessage.isNotEmpty() -> {
                // Error State
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            else -> {
                // Product Details Display
                product?.let {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        // Product Image
                        AsyncImage(
                            model = it.imageUrl,
                            contentDescription = it.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        // Product Name
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Product Price
                        Text(
                            text = "Price: $${it.price}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Product Description
                        Text(
                            text = it.description,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }
        }
    }
}

