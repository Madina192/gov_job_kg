package com.example.govjobkg.ui.hr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.govjobkg.base.BaseViewModel
import com.example.govjobkg.network.MainRepository
import com.example.govjobkg.network.models.Vacancy

class MainHrViewModel : BaseViewModel() {

    private val mainRepository = MainRepository()

    private val _requestResult: MutableLiveData<Unit> = MutableLiveData()
    val requestResult: LiveData<Unit> = _requestResult


    fun postVacancy(vacancy: Vacancy) {
        request(
            networkCall = {mainRepository.postVacancy(vacancy)},
            onSuccess =  {
                _requestResult.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}