package com.movieapp.kotlin.data.remote

import com.movieapp.kotlin.domain.model.GetAllMoviesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiServices {


    @GET("/movie/top_rated")
    fun getAllMovies() : Single<GetAllMoviesResponse>


}