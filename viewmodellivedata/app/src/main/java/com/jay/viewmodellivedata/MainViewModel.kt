package com.jay.viewmodellivedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val TAG: String = "로그"

    private val _following = MutableLiveData<String>()
    private val _counter = MutableLiveData<Int>()

    val following: LiveData<String>
        get() = _following
    val counter: LiveData<Int>
        get() = _counter

    fun increase() {
        Log.d(TAG, "MainViewModel ~ increase() called")
        _counter.value = _counter.value?.plus(1)
    }

    fun decrease() {
        Log.d(TAG, "MainViewModel ~ decrease() called")
        _counter.value = _counter.value?.minus(1)
    }

    fun updateFollow(input: Int?) {
        _following.value = "팔로잉 " + input + "명"
    }

    init {
        Log.d(TAG, "MainViewModel ~ init() called")
        _following.value = "팔로잉 0명"
        _counter.value = 0
    }

}