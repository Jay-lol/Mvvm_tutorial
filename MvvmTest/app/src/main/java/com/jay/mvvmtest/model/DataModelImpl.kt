package com.jay.mvvmtest.model

import com.jay.mvvmtest.model.response.AfcSearchResponse
import com.jay.mvvmtest.model.service.AfcService
import io.reactivex.Single

class DataModelImpl(private val service : AfcService)  : DataModel{
    override fun getData(bid : String) : Single<AfcSearchResponse> {
        return service.searchInfo(header = "Mozilla/5.0", userId = bid)
    }
}