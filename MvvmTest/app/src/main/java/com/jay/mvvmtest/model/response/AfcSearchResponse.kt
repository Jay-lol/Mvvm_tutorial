package com.jay.mvvmtest.model.response

import com.google.gson.annotations.SerializedName

data class AfcSearchResponse(
    @SerializedName("profile_image")
    var profile : String,
    var station : Station?,
    var broad : Broad?
    )
