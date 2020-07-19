package com.qf.gank.http.result

import com.qf.gank.http.exception.ApiException

open class ApiResult<T>(val status: Int? = null, val errorMsg: String? = null, private val data: T? = null) {
    fun apiData(): T? {
        if (status == 100) {
            return data
        } else {
            throw ApiException(status, errorMsg)
        }
    }
}