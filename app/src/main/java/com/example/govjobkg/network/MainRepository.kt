package com.example.govjobkg.network

import com.example.govjobkg.network.models.MovieResponse
import com.example.govjobkg.network.models.Resume
import com.example.govjobkg.network.models.ResumeResponse
import com.example.govjobkg.network.models.Vacancy
import com.example.govjobkg.util.apiRequest

class MainRepository {
    private val movieService = RetrofitClient.ApiClient.apiService

    suspend fun getMovies(
    ): ApiResponse<MovieResponse> {
        return apiRequest { movieService.getMovies() }
    }

    suspend fun createResume(request : Resume): ApiResponse<ResumeResponse> {
        return apiRequest { movieService.createResume(request) }
    }

    suspend fun getJobs(): ApiResponse<List<Vacancy>> {
        return apiRequest { movieService.getJobs() }
    }

}