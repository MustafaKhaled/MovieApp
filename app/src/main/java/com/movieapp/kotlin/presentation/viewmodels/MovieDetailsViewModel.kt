package com.movieapp.kotlin.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.movieapp.kotlin.domain.model.details.MovieDetails
import com.movieapp.kotlin.domain.model.toprated.GetAllMoviesResponse
import com.movieapp.kotlin.domain.usecases.business.MovieDetailsUseCase

class MovieDetailsViewModel constructor(private val movieDetailsUseCase: MovieDetailsUseCase) : ViewModel() {
    private val getMovieDetails = MutableLiveData<MovieDetails>()
    private val isDataLoaded = MutableLiveData<Boolean>()
    init {
        isDataLoaded.value = false
    }

    fun requestMovieDetails(movieId:Int){
        movieDetailsUseCase.setMovieId(movieId)
        movieDetailsUseCase.execute(onSuccess = {
            getMovieDetails.value = it
            isDataLoaded.value = true
        }, onFailure = {
            it.printStackTrace()
            isDataLoaded.value = true
        })
    }

    fun getMovieDetails() : LiveData<MovieDetails> {
        return getMovieDetails
    }

    fun isDataLoaded() : LiveData<Boolean> {
        return isDataLoaded
    }
}