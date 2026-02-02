package org.example.project.di

import org.example.project.data.remote.service.PostService
import org.example.project.data.repository.AuthRepositoryImpl
import org.example.project.domain.repository.PostRepository
import org.example.project.domain.usecase.GetPostsUseCase
import org.example.project.presentation.features.posts.PostViewModel
import org.koin.core.module.dsl.viewModel
import org.example.project.data.repository.PostRepositoryImpl
import org.example.project.domain.repository.AuthRepository
import org.example.project.domain.usecase.LoginUseCase
import org.example.project.presentation.auth.login.LoginViewModel

import org.koin.dsl.module

val appModule = module {
    single<PostRepository> { PostRepositoryImpl(get()) }

    // --- Domain Layer ---
    factory { GetPostsUseCase(get()) }

    // --- Presentation Layer ---
    factory { PostViewModel(get()) }

    factory { LoginViewModel(get()) }

    // 👇 1. ต้องมี Repository (สำหรับ Login)
    single<AuthRepository> { AuthRepositoryImpl(get()) }

    // 👇 2. ต้องมี UseCase (สำคัญมาก! อันนี้มักจะลืม)
    factory { LoginUseCase(get()) }

    // 👇 3. ต้องมี ViewModel (สำหรับหน้า Login)
    factory { LoginViewModel(get()) }
}