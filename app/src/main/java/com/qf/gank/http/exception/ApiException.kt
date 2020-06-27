package com.qf.gank.http.exception

class ApiException(var status: Int? = null, override var message: String? = null) : RuntimeException()