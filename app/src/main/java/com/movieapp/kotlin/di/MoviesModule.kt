package com.movieapp.kotlin.di

import com.movieapp.kotlin.data.remote.ApiServices
import com.movieapp.kotlin.data.repo.GetAllMoviesRepoImpl
import com.movieapp.kotlin.domain.repo.GetAllMoviesRepo
import com.movieapp.kotlin.domain.usecases.business.GetAllMoviesUseCase
import com.movieapp.kotlin.presentation.viewmodels.GetAllMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MoviesModules = module {
    single { createGetAllMoviesUseCase(get()) }
    single { createGetAllMoviesRepoInstance(get()) }
    viewModel { GetAllMoviesViewModel(get()) }
}


fun createGetAllMoviesRepoInstance(apiServices: ApiServices): GetAllMoviesRepo {
    return GetAllMoviesRepoImpl(apiServices)
}

fun createGetAllMoviesUseCase(getAllMoviesRepo: GetAllMoviesRepo): GetAllMoviesUseCase {
    return GetAllMoviesUseCase(getAllMoviesRepo)
}
