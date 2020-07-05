package com.qf.gank.http.api

import com.qf.gank.bean.banner.BannerBean
import com.qf.gank.http.result.ApiResult
import retrofit2.Call
import retrofit2.http.GET

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：APIS
 */
interface APIS {

    @GET("banners")
    suspend fun getBanners() : ApiResult<List<BannerBean>>
}