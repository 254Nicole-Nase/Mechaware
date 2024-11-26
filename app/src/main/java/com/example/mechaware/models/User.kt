package com.example.mechaware.models

data class User(
    val name: String,
    val email: String,
    val profileImage: String, // Ensure this exists
    val bio: String? // Nullable bio field
)