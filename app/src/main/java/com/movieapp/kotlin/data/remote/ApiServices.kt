package com.movieapp.kotlin.data.remote

import MovieDetails
import com.movieapp.kotlin.domain.model.toprated.GetAllMoviesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {


    @GET("movie/top_rated")
    fun getAllMovies(@Query("api_key") apiKey : String) : Single<GetAllMoviesResponse>


    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId : Int) : Single<MovieDetails>
}