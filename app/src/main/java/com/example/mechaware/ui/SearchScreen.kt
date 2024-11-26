package com.example.mechaware.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mechaware.models.Product
import com.google.firebase.database.FirebaseDatabase

fun fetchAllProducts(onSuccess: (List<Product>) -> Unit, onFailure: (String) -> Unit) {
    val productList = mutableListOf<Product>()
    val database = FirebaseDatabase.getInstance()
    val productRef = database.getReference("products")

    productRef.get().addOnSuccessListener { snapshot ->
        snapshot.children.forEach { data ->
            val product = data.getValue(Product::class.java)
            if (product != null) {
                productList.add(product)
            }
        }
        onSuccess(productList)
    }.addOnFailureListener { exception ->
        onFailure(exception.message ?: "Error fetching products")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, query: String) {
    var searchQuery by remember { mutableStateOf(query) }  // Initialize search query with the provided query
    var filteredProducts by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Trigger product fetching and filtering when the query changes
    LaunchedEffect(searchQuery) {
        isLoading = true
        errorMessage = null

        fetchAllProducts(
            onSuccess = { allProducts ->
                filteredProducts = allProducts.filter { it.name.contains(searchQuery, ignoreCase = true) }
                isLoading = false
            },
            onFailure = { error ->
                errorMessage = error
                isLoading = false
            }
        )
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Search Results for \"$searchQuery\"") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Search field UI
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { newQuery -> searchQuery = newQuery },  // Update search query on change
                label = { Text("Search products") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            when {
                isLoading -> {
                    // Show loading spinner
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                errorMessage != null -> {
                    // Show error message if fetching fails
                    Text(
                        text = errorMessage ?: "Unknown error",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
                filteredProducts.isEmpty() -> {
                    // No products found for the query
                    Text("No products found for \"$searchQuery\"")
                }
                else -> {
                    // Display the list of filtered products
                    LazyColumn {
                        items(filteredProducts) { product ->
                            ProductItem(product = product, onClick = {
                                // Navigate to product details
                                navController.navigate("product_details/${product.id}")
                            })
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}
