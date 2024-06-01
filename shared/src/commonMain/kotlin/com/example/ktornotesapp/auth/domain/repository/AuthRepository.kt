package com.example.ktornotesapp.auth.domain.repository

import com.example.ktornotesapp.auth.domain.model.AuthResultData
import com.example.socialmediaapp.common.util.Result

internal interface AuthRepository {
    suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Result<AuthResultData>

    suspend fun signIn(
        email: String,
        password: String
    ): Result<AuthResultData>
}