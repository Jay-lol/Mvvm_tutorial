package com.jay.livedataViewmodelTutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val _following = MutableLiveData<String>()
    private val _counter = MutableLiveData<Int>()

    val following: LiveData<String>
        get() = _following
    val counter: LiveData<Int>
        get() = _counter

        fun increase() {
            _counter.value = _counter.value?.plus(1)
        }

        fun decrease() {
            _counter.value = _counter.value?.minus(1)
        }

    init {
        _following.value = "팔로잉 0명"
        _counter.value = 0
    }

}