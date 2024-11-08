package com.example.govjobkg.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.govjobkg.base.BaseViewModel
import com.example.govjobkg.network.MainRepository
import com.example.govjobkg.network.models.MovieResponse

class AuthViewModel: BaseViewModel() {


    private val _movies = MutableLiveData<MovieResponse>()
    val movies: LiveData<MovieResponse>  = _movies

    private val mainRepository = MainRepository()



     fun getMovies() {
        request(
            networkCall = { mainRepository.getMovies()},
            onSuccess =  {
                _movies.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

}