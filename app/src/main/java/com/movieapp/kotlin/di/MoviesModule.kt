package com.movieapp.kotlin.di

import com.movieapp.kotlin.data.remote.ApiServices
import com.movieapp.kotlin.data.repo.GetAllMoviesRepoImpl
import com.movieapp.kotlin.data.repo.MovieDetailsRepoImpl
import com.movieapp.kotlin.domain.repo.GetAllMoviesRepo
import com.movieapp.kotlin.domain.repo.GetMovieDetailsRepo
import com.movieapp.kotlin.domain.usecases.business.GetAllMoviesUseCase
import com.movieapp.kotlin.domain.usecases.business.MovieDetailsUseCase
import com.movieapp.kotlin.presentation.viewmodels.GetAllMoviesViewModel
import com.movieapp.kotlin.presentation.viewmodels.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MoviesModules = module {
    single { createGetAllMoviesUseCase(get()) }
    single { createGetAllMoviesRepoInstance(get()) }
    single { createGetDetailsRepoInstance(get()) }
    single { createGetMovieDetailsUseCase(get()) }
    viewModel { GetAllMoviesViewModel(get()) }
    viewModel { MovieDetailsViewModel(get()) }
}


fun createGetAllMoviesRepoInstance(apiServices: ApiServices): GetAllMoviesRepo {
    return GetAllMoviesRepoImpl(apiServices)
}

fun createGetAllMoviesUseCase(getAllMoviesRepo: GetAllMoviesRepo): GetAllMoviesUseCase {
    return GetAllMoviesUseCase(getAllMoviesRepo)

    }
fun createGetDetailsRepoInstance(apiServices: ApiServices): GetMovieDetailsRepo {
    return MovieDetailsRepoImpl(apiServices)
}

fun createGetMovieDetailsUseCase(getMovieDetails: GetMovieDetailsRepo): MovieDetailsUseCase {
    return MovieDetailsUseCase(getMovieDetails)

}