package com.movieapp.kotlin.domain.repo

import com.movieapp.kotlin.domain.model.GetAllMoviesResponse
import io.reactivex.Single

interface GetAllMoviesRepo {
    fun getAllMovies(apiKey : String) : Single<GetAllMoviesResponse>
}