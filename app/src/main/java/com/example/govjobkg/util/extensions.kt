package com.example.govjobkg.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.govjobkg.network.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


fun View.show() {
    isVisible = true
}

fun View.hide() {
    isVisible = false
}

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}

suspend fun <T> apiRequest(apiCall: suspend () -> T): ApiResponse<T> {
    return try {
        ApiResponse.Success(
            withContext(Dispatchers.IO) { apiCall() }
        )
    } catch (ex: Exception) {
        ApiResponse.Error(ex)

    }
}

