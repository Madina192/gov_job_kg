package com.example.govjobkg.network

import com.example.govjobkg.network.models.MovieResponse
import com.example.govjobkg.util.apiRequest

class MainRepository {
    private val movieService = RetrofitClient.ApiClient.apiService

    suspend fun getMovies(
    ): ApiResponse<MovieResponse> {
        return apiRequest { movieService.getMovies() }
    }

}