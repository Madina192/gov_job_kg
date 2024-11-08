package com.example.govjobkg.network

import com.example.govjobkg.util.apiRequest
import com.google.movietv.model.MovieResponse

class MainRepository {
    private val movieService = RetrofitClient.ApiClient.apiService

    suspend fun getMovies(
    ): ApiResponse<MovieResponse> {
        return apiRequest { movieService.getMovies() }
    }

}