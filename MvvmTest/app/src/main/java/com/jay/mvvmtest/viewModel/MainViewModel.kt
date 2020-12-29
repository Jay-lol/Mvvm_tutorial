package com.jay.mvvmtest.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jay.mvvmtest.BaseKotlinViewModel
import com.jay.mvvmtest.model.DataModel
import com.jay.mvvmtest.model.response.AfcSearchResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import java.util.concurrent.TimeUnit

class MainViewModel(private val model: DataModel) : BaseKotlinViewModel() {
    private val TAG: String = "로그"

    private val _afcSearchResponseLiveData: MutableLiveData<List<AfcSearchResponse>> =
        MutableLiveData()
    val afcSearchResponseLiveData = _afcSearchResponseLiveData

    fun getBjSearch(bid: String) {
        addDisposable(
            model.getData(bid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "MainViewModel ~ getBjSearch() called ${it.profile}")
//                    _afcSearchResponseLiveData.postValue(it)
                }, {
                    Log.d(TAG, "MainViewModel ~ getBjSearch() called ${it.message}")
                })
        )
    }
    fun getBjListSearch(bidList: List<String>) {

        val singles = (bidList).map {
            model.getData(it)
                .timeout(1, TimeUnit.SECONDS)
                .onErrorReturn { z-> AfcSearchResponse(profile = "하이", station = null, broad = null) }
        }.toList()

        addDisposable(
            Single.zip(singles.map { it.subscribeOn(Schedulers.io()) }
            ) { array ->
                for (i in array)
                    Log.d(TAG, "MainViewModel ~ getBjListSearch() called $i")
                array
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "MainViewModel ~ getBjSearch() finished ${it.size}")
                    val arr = it.map { it as AfcSearchResponse }
                    for (i in it)
                        Log.d(TAG, "MainViewModel ~ getBjListSearch() called ${i as AfcSearchResponse}")
                    _afcSearchResponseLiveData.postValue(arr)
                }, {
                    Log.e(TAG, "MainViewModel ~ getBjSearch() called $it")
                })
        )
    }
}