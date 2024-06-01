package com.example.ktornotesapp.auth.domain.model

data class AuthResultData(
    val userId: Long,
    val name: String,
    val bio: String,
    val imageUrl: String? = null,
)