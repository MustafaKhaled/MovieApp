package com.movieapp.kotlin.domain.repo

import MovieDetails
import com.movieapp.kotlin.domain.model.toprated.GetAllMoviesResponse
import io.reactivex.Single

interface GetMovieDetailsRepo {
    fun getMovieDetails(apiKey : String, movieId : Int) : Single<MovieDetails>
}