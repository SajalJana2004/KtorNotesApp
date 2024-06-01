package com.example.ktornotesapp.auth.domain.usecases

import com.example.ktornotesapp.auth.domain.model.AuthResultData
import com.example.ktornotesapp.auth.domain.repository.AuthRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.example.socialmediaapp.common.util.Result


class SignInUseCase : KoinComponent {

    private val repository: AuthRepository by inject()

    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<AuthResultData> {
        if (email.isBlank() || "@" !in email) {
            return Result.Error(
                message = "Invalid email"
            )
        }
        if (password.isBlank() || password.length < 6) {
            return Result.Error(
                message = "Invalid password or too short!"
            )
        }

        return repository.signIn(email, password)
    }


}