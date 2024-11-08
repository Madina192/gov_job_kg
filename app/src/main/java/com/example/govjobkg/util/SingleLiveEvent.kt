package com.example.govjobkg.util

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {
    private val eventState = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, Observer {
            if (eventState.compareAndSet(true, false)) observer.onChanged(it)
        })
    }

    @MainThread
    override fun setValue(value: T) {
        eventState.set(true)
        super.setValue(value)
    }
}
