package com.example.govjobkg.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.govjobkg.network.ApiResponse
import com.example.govjobkg.util.ServiceCallState
import com.example.govjobkg.util._serviceCallState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {


    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> get() = _loading

    protected inline fun <T> request(
        crossinline networkCall: suspend CoroutineScope.() -> ApiResponse<T>,
        crossinline onError: (Exception) -> Unit = { },
        crossinline onSuccess: (data: T) -> Unit,
    ) {
        viewModelScope.launch {
            _serviceCallState.postValue(ServiceCallState.LOADING)
            val result = networkCall()
            _serviceCallState.postValue(ServiceCallState.SUCCESS)
            processResult(result, onError, onSuccess)
        }
    }

    protected inline fun <T> processResult(
        result: ApiResponse<T>,
        crossinline onError: (Exception) -> Unit = { },
        crossinline onSuccess: (data: T) -> Unit
    ) {
        when (result) {
            is ApiResponse.Success -> {
                onSuccess(result.data)
                _serviceCallState.postValue(ServiceCallState.SUCCESS)
            }
            is ApiResponse.Error -> {
                onError(result.exception)
                _serviceCallState.postValue(ServiceCallState.FAILURE)
            }
        }
    }

}