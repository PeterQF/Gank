package com.qf.gank.ui.home

import com.qf.gank.http.client.RetrofitClient

/**
 * 作者：PeterWu
 * 时间：2020/7/11
 * 描述：HomeRepository
 */
class HomeRepository {

    suspend fun getBanner() = RetrofitClient.getService.getBanners().apiData()

    suspend fun getCategory(type: String) = RetrofitClient.getService.getCategory(type).apiData()
}