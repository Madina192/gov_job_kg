package com.example.govjobkg.network

import com.example.govjobkg.network.models.MovieResponse
import com.example.govjobkg.network.models.Vacancy
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MainService {

    @GET("movie/popular?language=en-US")
    suspend fun getMovies(
        @Query("page") page: Int = 1,
    ): MovieResponse



    @POST("http://192.168.5.47:8000/jobs/")
    suspend fun postVacancy(
        @Body innRequestBody: Vacancy
    )


}