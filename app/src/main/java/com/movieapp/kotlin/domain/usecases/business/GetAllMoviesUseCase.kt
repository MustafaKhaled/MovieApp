package com.movieapp.kotlin.domain.usecases.business

import com.movieapp.kotlin.BuildConfig
import com.movieapp.kotlin.domain.model.GetAllMoviesResponse
import com.movieapp.kotlin.domain.repo.GetAllMoviesRepo
import com.movieapp.kotlin.domain.usecases.core.UseCasePrimary
import io.reactivex.Single

class GetAllMoviesUseCase constructor(private val getAllMoviesRepo: GetAllMoviesRepo) : UseCasePrimary<GetAllMoviesResponse>() {

    override fun buildUseCasePrimary(): Single<GetAllMoviesResponse> {
        return getAllMoviesRepo.getAllMovies(BuildConfig.API_KEY)
    }
}