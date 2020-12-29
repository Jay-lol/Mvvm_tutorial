package com.jay.mvvmtest.model.service

import com.jay.mvvmtest.model.response.AfcSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface AfcService {
    @GET("/api/{userId}/station")
    fun searchInfo(
        @Header("User-Agent") header : String,
        @Path("userId") userId :String
    ): Single<AfcSearchResponse>
}