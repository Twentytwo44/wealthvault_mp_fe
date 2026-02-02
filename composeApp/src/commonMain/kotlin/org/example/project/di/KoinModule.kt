package org.example.project.di

import org.example.project.data.remote.service.PostService
import org.example.project.domain.repository.PostRepository
import org.example.project.domain.usecase.GetPostsUseCase
import org.example.project.presentation.features.posts.PostViewModel
import org.koin.core.module.dsl.viewModel
import org.example.project.data.repository.PostRepositoryImpl

import org.koin.dsl.module

val appModule = module {
    single<PostRepository> { PostRepositoryImpl(get()) }

    // --- Domain Layer ---
    factory { GetPostsUseCase(get()) }

    // --- Presentation Layer ---
    factory { PostViewModel(get()) }
}