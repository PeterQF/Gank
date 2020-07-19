package com.qf.gank.http.result

import com.qf.gank.http.exception.ApiException

data class ApiArticleResult<T>(
    val status: Int? = null,
    val errorMsg: String? = null,
    val page: Int = 0,
    val page_count: Int = 0,
    val total_counts: Int = 0,
    val data: T? = null
) {
    fun getResult(): ApiArticleResult<T> {
        if (status == 100) {
            return this
        } else {
            throw ApiException(status, errorMsg)
        }
    }
}