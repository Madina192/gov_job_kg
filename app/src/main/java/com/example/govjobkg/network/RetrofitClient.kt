package com.example.govjobkg.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

object RetrofitClient {
    private const val BASE_URL = "http://127.0.0.1:8000/"
    const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w185"
    private const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjMDhjODA0YzhmNDkxYTExMTE5MTUzMDU4ZGZkODE2OCIsIm5iZiI6MTcyOTUxMjE2NS4yNDgwNjQsInN1YiI6IjY0OTdmODI0YjM0NDA5MDBmZmVjNzZhMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5-Zfi-04i2RsI5KekBmXj6jc8FifYoa6aC8h0yt6jDw"

    private val authInterceptor = Interceptor { chain->
        var request = chain.request()
        request = request
            .newBuilder()
            .header("Authorization","Bearer ${API_KEY}")
            .build()
        chain.proceed(request)
    }

    private val loggingInterceptor =  HttpLoggingInterceptor().apply {
        level =
            HttpLoggingInterceptor.Level.BODY
    }


    private val okkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okkHttpClient)
            .build()
    }


    object ApiClient {
        val apiService: MainService by lazy {
            retrofit.create(MainService::class.java)
        }
    }

}