package com.movieapp.kotlin.domain.model

import com.google.gson.annotations.SerializedName


data class GetAllMoviesResponse (

	@SerializedName("page") val page : Int,
	@SerializedName("results") val results : List<SingleMovieModel>,
	@SerializedName("total_results") val totalResults : Int,
	@SerializedName("total_pages") val totalPages : Int
)