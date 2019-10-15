package com.movieapp.kotlin.data.repo

import com.movieapp.kotlin.data.remote.ApiServices
import com.movieapp.kotlin.domain.model.GetAllMoviesResponse
import com.movieapp.kotlin.domain.repo.GetAllMoviesRepo
import io.reactivex.Single

class GetAllMoviesRepoImpl(private val apiServices : ApiServices) : GetAllMoviesRepo {

    override fun getAllMovies(): Single<GetAllMoviesResponse> {
        return apiServices.getAllMovies()
    }
}