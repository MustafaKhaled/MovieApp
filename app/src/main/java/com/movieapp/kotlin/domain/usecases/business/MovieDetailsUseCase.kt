package com.movieapp.kotlin.domain.usecases.business

import MovieDetails
import com.movieapp.kotlin.BuildConfig
import com.movieapp.kotlin.domain.repo.GetMovieDetailsRepo
import com.movieapp.kotlin.domain.usecases.core.UseCasePrimary
import io.reactivex.Single

class MovieDetailsUseCase constructor(private val getMovieDetailsRepo: GetMovieDetailsRepo) : UseCasePrimary<MovieDetails>(){
    private var id : Int = -1
    override fun buildUseCasePrimary(): Single<MovieDetails> {
        return getMovieDetailsRepo.getMovieDetails(BuildConfig.API_KEY,id)
    }

    fun setMovieId(movieId: Int){
        id = movieId
    }

}