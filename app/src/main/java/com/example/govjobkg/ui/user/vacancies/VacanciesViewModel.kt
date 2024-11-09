package com.example.govjobkg.ui.user.vacancies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.govjobkg.base.BaseViewModel
import com.example.govjobkg.network.MainRepository
import com.example.govjobkg.network.models.Resume
import com.example.govjobkg.network.models.ResumeResponse
import com.example.govjobkg.network.models.Vacancy

class VacanciesViewModel : BaseViewModel(){

    private val _getJobs = MutableLiveData<List<Vacancy>>()
    val getJobs: LiveData<List<Vacancy>> = _getJobs

    private val mainRepository = MainRepository()



    fun getJobs() {
        request(
            networkCall = { mainRepository.getJobs()},
            onSuccess =  {
                _getJobs.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}