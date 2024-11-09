package com.example.govjobkg.network

import com.example.govjobkg.network.models.MovieResponse
import com.example.govjobkg.network.models.Resume
import com.example.govjobkg.network.models.ResumeResponse
import com.example.govjobkg.network.models.Vacancy
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MainService {

    @GET("movie/popular?language=en-US")
    suspend fun getMovies(
        @Query("page") page: Int = 1,
    ): MovieResponse

    @POST("/create-resume/")
    suspend fun createResume(
        @Body request : Resume
    ): ResumeResponse

    @GET("/jobs/")
    suspend fun getJobs(): List<Vacancy>
}