package com.movieapp.kotlin.domain.repo

import com.movieapp.kotlin.domain.model.details.MovieDetails
import io.reactivex.Single

interface GetMovieDetailsRepo {
    fun getMovieDetails(apiKey : String, movieId : Int) : Single<MovieDetails>
}