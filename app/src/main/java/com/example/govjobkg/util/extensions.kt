package com.example.govjobkg.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
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


fun View.visible(animate: Boolean = false, duration: Long = 300) {
    if (animate) {
        animate().alpha(1f).setDuration(duration).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                visibility = View.VISIBLE
            }
        })
    } else {
        visibility = View.VISIBLE
    }
}

fun View.gone(animate: Boolean = false, duration: Long = 300) {
    hide(View.GONE, animate, duration)
}

private fun View.hide(hidingStrategy: Int, animate: Boolean = true, duration: Long = 300) {
    if (animate) {
        animate().alpha(0f).setDuration(duration).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                visibility = hidingStrategy
            }
        })
    } else {
        visibility = hidingStrategy
    }
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

