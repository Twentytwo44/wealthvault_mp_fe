package org.example.project.di

import org.example.project.data.remote.KtorClient
import org.example.project.data.remote.service.PostService
import org.example.project.domain.repository.PostRepository
import org.example.project.domain.usecase.GetPostsUseCase
import org.example.project.presentation.features.posts.PostViewModel
import org.koin.core.module.dsl.viewModel

import org.koin.dsl.module

val appModule = module {
    // --- Data Layer ---
    // 1. Singleton HttpClient (ตัวแม่)
    single { KtorClient.client }

    // 2. Factory Service (รับ HttpClient เข้ามา)
    // ใช้ factory เพราะ Service มักจะเบา และ state less
    factory { PostService(get()) }

    // 3. Repository (รับ Service เข้ามา)
    // Bind Interface (PostRepository) เข้ากับ Implementation (PostRepositoryImpl)
    single<PostRepository> { PostRepositoryImpl(get()) }

    // --- Domain Layer ---
    // 4. UseCase (รับ Repository เข้ามา)
    // ใช้ factory เสมอสำหรับ UseCase เพราะมันคือ Action (ทำแล้วจบไป)
    factory { GetPostsUseCase(get()) }

    // --- Presentation Layer ---
    // 5. ViewModel (รับ UseCase เข้ามา)
    // ใช้ viewModel { ... } (ต้องลง library koin-android หรือ koin-compose)
    factory { PostViewModel(get()) }
}