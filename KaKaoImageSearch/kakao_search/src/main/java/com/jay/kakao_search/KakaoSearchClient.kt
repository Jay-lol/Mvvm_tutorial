package com.jay.kakao_search

import com.jay.kakao_search.enums.KakaoSearchBookTargetType
import com.jay.kakao_search.enums.KakaoSearchSortType
import com.jay.kakao_search.model.*
import com.jay.kakao_search.network.KakaoSearchApi
import com.jay.kakao_search.network.NetworkManager
import retrofit2.create

fun kakaoSearchClient(
    apiKey: String,
) = lazy {
    val keyHeaderValue = "KakaoAK $apiKey"
    KakaoSearchClient(keyHeaderValue)
}

class KakaoSearchClient(
    private val kakaoRestApiKey: String,
) {

    private val kakaoSearchApi by lazy {
        NetworkManager.retrofit.create<KakaoSearchApi>()
    }

    suspend fun searchWeb(
        query: String,
        sort: KakaoSearchSortType = KakaoSearchSortType.ACCURACY,
        page: Int = 1,
        size: Int = 10,
    ): BaseKakaoResponse<KakaoWebResponse> {
        return kakaoSearchApi.searchWeb(kakaoRestApiKey, query, sort, page, size)
    }

    suspend fun searchVclip(
        query: String,
        sort: KakaoSearchSortType = KakaoSearchSortType.ACCURACY,
        page: Int = 1,
        size: Int = 15,
    ): BaseKakaoResponse<KakaoVclipResponse> {
        return kakaoSearchApi.searchVclip(kakaoRestApiKey, query, sort, page, size)
    }

    suspend fun searchImage(
        query: String,
        sort: KakaoSearchSortType = KakaoSearchSortType.ACCURACY,
        page: Int = 1,
        size: Int = 80,
    ): BaseKakaoResponse<KakaoImageResponse> {
        return kakaoSearchApi.searchImage(kakaoRestApiKey, query, sort, page, size)
    }

    suspend fun searchBlog(
        query: String,
        sort: KakaoSearchSortType = KakaoSearchSortType.ACCURACY,
        page: Int = 1,
        size: Int = 10,
    ): BaseKakaoResponse<KakaoBlogResponse> {
        return kakaoSearchApi.searchBlog(kakaoRestApiKey, query, sort, page, size)
    }

    suspend fun searchBook(
        query: String,
        sort: KakaoSearchSortType = KakaoSearchSortType.ACCURACY,
        page: Int = 1,
        size: Int = 10,
        target: KakaoSearchBookTargetType? = null,
    ): BaseKakaoResponse<KakaoBookResponse> {
        return kakaoSearchApi.searchBook(kakaoRestApiKey, query, sort, page, size, target)
    }

    suspend fun searchCafe(
        query: String,
        sort: KakaoSearchSortType = KakaoSearchSortType.ACCURACY,
        page: Int = 1,
        size: Int = 10,
    ): BaseKakaoResponse<KakaoCafeResponse> {
        return kakaoSearchApi.searchCafe(kakaoRestApiKey, query, sort, page, size)
    }


}