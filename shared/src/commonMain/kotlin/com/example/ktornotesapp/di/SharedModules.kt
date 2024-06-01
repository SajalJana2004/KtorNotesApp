package com.example.ktornotesapp.di

import com.example.ktornotesapp.auth.data.AuthRepositoryImpl
import com.example.ktornotesapp.auth.data.AuthService
import com.example.ktornotesapp.auth.domain.repository.AuthRepository
import com.example.ktornotesapp.auth.domain.usecases.SignInUseCase
import com.example.ktornotesapp.auth.domain.usecases.SignUpUseCase
import com.example.socialmediaapp.common.util.provideDispatcher
import org.koin.dsl.module

private val authModule = module {
    single <AuthRepository>{AuthRepositoryImpl(get(),get())  }
    factory { AuthService() }
    factory { SignUpUseCase() }
    factory { SignInUseCase() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

fun getSharedModules() = listOf(authModule, utilityModule)