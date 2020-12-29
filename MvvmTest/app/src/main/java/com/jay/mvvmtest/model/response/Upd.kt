package com.jay.mvvmtest.model.response

data class Upd(
    val user_id: String, val asp_code: Int,
    val fan_cnt: Int,
    val today0_visit_cnt: Int,
    val today1_visit_cnt: Int,
    val total_visit_cnt: Int,
    val today0_ok_cnt: Int,
    val today1_ok_cnt: Int,
    val today0_fav_cnt: Int,
    val today1_fav_cnt: Int,
    val total_ok_cnt: Int,
    val total_view_cnt: Int
)
