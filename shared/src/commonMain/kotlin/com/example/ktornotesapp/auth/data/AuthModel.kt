package com.example.ktornotesapp.auth.data

import kotlinx.serialization.Serializable


@Serializable
data class SignUpRequest(
    val name: String, val email: String, val password: String
)

@Serializable
data class SignInRequest(
    val email: String, val password: String
)

@Serializable
data class AuthResponse(
    val data: AuthResponseData? = null,
    val errorMessage: String? = null
)

@Serializable
data class AuthResponseData(
    val userId: Long,
    val name: String,
    val bio: String,
    val imageUrl:String,
    val token: String,
)