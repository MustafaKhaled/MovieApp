package com.movieapp.kotlin.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.movieapp.kotlin.domain.model.GetAllMoviesResponse
import com.movieapp.kotlin.domain.usecases.business.GetAllMoviesUseCase

class GetAllMoviesViewModel constructor(private val getAllMoviesUseCase: GetAllMoviesUseCase) : ViewModel() {


    private val getAllMoviesLiveData = MutableLiveData<GetAllMoviesResponse>()
    private val isDataLoaded = MutableLiveData<Boolean>()

    init {
        isDataLoaded.value = false
    }

    fun loadAllMovies() {
        getAllMoviesUseCase.execute(onSuccess = {
            getAllMoviesLiveData.value = it
            isDataLoaded.value = true
        }, onFailure = {
            it.printStackTrace()
            isDataLoaded.value = true
        }
        )
    }

    fun getMovies() : LiveData<GetAllMoviesResponse>{
        return getAllMoviesLiveData
    }

    fun isDataLoaded() : LiveData<Boolean>{
        return isDataLoaded
    }
}