package com.jay.mvvmtest.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jay.mvvmtest.BaseKotlinViewModel
import com.jay.mvvmtest.model.DataModel
import com.jay.mvvmtest.model.response.AfcSearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val model: DataModel) : BaseKotlinViewModel() {
    private val TAG: String = "로그"

    private val _afcSearchResponseLiveData: MutableLiveData<AfcSearchResponse> =
        MutableLiveData()
    val afcSearchResponseLiveData = _afcSearchResponseLiveData

    fun getBjSearch(bid: String) {
        addDisposable(
            model.getData(bid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "MainViewModel ~ getBjSearch() called $it")
                    Log.d(TAG, "MainViewModel ~ getBjSearch() called ${it.profile}")
                    _afcSearchResponseLiveData.postValue(it)
                }, {
                    Log.d(TAG, "MainViewModel ~ getBjSearch() called ${it.message}")
                })
        )
    }
}