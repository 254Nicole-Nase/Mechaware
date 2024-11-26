package com.example.mechaware.services

import com.google.firebase.database.*
import com.example.mechaware.models.Product

fun fetchProducts(
    onSuccess: (List<Product>) -> Unit,
    onFailure: (String) -> Unit
) {
    val database = FirebaseDatabase.getInstance()
    val productsRef = database.getReference("products")

    productsRef.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val products = mutableListOf<Product>()
            for (productSnapshot in snapshot.children) {
                val product = productSnapshot.getValue(Product::class.java)
                if (product != null) {
                    products.add(product)
                }
            }
            onSuccess(products)
        }

        override fun onCancelled(error: DatabaseError) {
            onFailure(error.message)
        }
    })
}
