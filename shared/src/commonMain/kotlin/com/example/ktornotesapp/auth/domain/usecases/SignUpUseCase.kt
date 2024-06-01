package com.example.ktornotesapp.auth.domain.usecases

import com.example.ktornotesapp.auth.domain.model.AuthResultData
import com.example.ktornotesapp.auth.domain.repository.AuthRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignUpUseCase : KoinComponent {

    private val repository: AuthRepository by inject()

    suspend operator fun invoke(
        name: String,
        email: String,
        password: String
    ): Result<AuthResultData> {
        if (name.isBlank() || name.length < 3) {
            return Result.Error(
                message = "Invalid name"
            )
        }
        if (email.isBlank() || "@" !in email) {
            return Result.Error(
                message = "Invalid email"
            )
        }
        if (password.isBlank() || password.length < 6 || !password.matches(Regex("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{6,}$"))) {
            return Result.Error(
                message = "Invalid password! It must be at least 6 characters long and contain letters, numbers, and special characters."
            )
        }

        return repository.signIn(email, password)
    }

}