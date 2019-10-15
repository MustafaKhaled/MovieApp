package com.movieapp.kotlin.data.remote

import com.movieapp.kotlin.domain.model.GetAllMoviesResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {


    @GET("movie/top_rated")
    fun getAllMovies(@Query("api_key") apiKey : String) : Single<GetAllMoviesResponse>


}