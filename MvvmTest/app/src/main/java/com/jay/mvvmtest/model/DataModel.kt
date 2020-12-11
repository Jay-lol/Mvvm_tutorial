package com.jay.mvvmtest.model

import com.jay.mvvmtest.model.response.AfcSearchResponse
import io.reactivex.Single

interface DataModel {
    fun getData(bid : String) : Single<AfcSearchResponse>
}