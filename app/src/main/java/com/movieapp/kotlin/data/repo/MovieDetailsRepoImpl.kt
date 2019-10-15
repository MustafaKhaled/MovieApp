package com.movieapp.kotlin.data.repo

import MovieDetails
import com.movieapp.kotlin.data.remote.ApiServices
import com.movieapp.kotlin.domain.repo.GetMovieDetailsRepo
import io.reactivex.Single

class MovieDetailsRepoImpl(private val apiServices: ApiServices) : GetMovieDetailsRepo {
    override fun getMovieDetails(apiKey: String, movieId: Int): Single<MovieDetails> {
        return apiServices.getMovieDetails(movieId)
    }
}