package com.qf.gank.ui.girl

import com.qf.gank.http.client.RetrofitClient

/**
 * 作者：PeterWu
 * 时间：2020/7/19
 * 描述：GirlRepository
 */
class GirlRepository {

    suspend fun getGirls(category: String, type: String, page: Int, count: Int) =
        RetrofitClient.getService.getArticle(category, type, page, count).getResult()
}