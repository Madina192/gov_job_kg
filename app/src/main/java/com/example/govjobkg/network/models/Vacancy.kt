package com.example.govjobkg.network.models

import com.google.gson.annotations.SerializedName

data class Vacancy(
    @SerializedName("title")
    val jobTitle : String,
    val salary : String,
    val company : String,
    val experience : String,
    val description : String
)