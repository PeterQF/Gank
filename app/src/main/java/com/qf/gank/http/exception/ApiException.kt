package com.qf.gank.http.exception

class ApiException(var status: Int? = null, var errorMessage: String? = null) : Throwable()