package com.example.mechaware.models

data class Product(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = "",
    val category: String = "",
    val condition: String = "",
    val tags: List<String> = listOf(),
    val sellerId: String = ""
)

