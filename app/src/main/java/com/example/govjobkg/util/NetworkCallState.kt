package com.example.govjobkg.util

import androidx.lifecycle.LiveData

enum class ServiceCallState {
    LOADING, SUCCESS, FAILURE
}

val _serviceCallState = SingleLiveEvent<ServiceCallState>()
val serviceCallState: LiveData<ServiceCallState> = _serviceCallState