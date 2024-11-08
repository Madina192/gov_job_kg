package com.example.govjobkg.network

import com.example.govjobkg.network.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("movie/popular?language=en-US")
    suspend fun getMovies(
        @Query("page") page: Int = 1,
    ): MovieResponse
}