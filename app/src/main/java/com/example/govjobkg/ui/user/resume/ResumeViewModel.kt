package com.example.govjobkg.ui.user.resume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.govjobkg.base.BaseViewModel
import com.example.govjobkg.network.MainRepository
import com.example.govjobkg.network.models.MovieResponse
import com.example.govjobkg.network.models.Resume
import com.example.govjobkg.network.models.ResumeResponse

class ResumeViewModel : BaseViewModel() {

    private val _createResumeResponse = MutableLiveData<ResumeResponse>()
    val createResumeResponse: LiveData<ResumeResponse> = _createResumeResponse

    private val mainRepository = MainRepository()



    fun createResume(request : Resume) {
        request(
            networkCall = { mainRepository.createResume(request)},
            onSuccess =  {
                _createResumeResponse.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}