package com.qf.gank.ui.home

import com.qf.gank.bean.article.ArticleBean
import com.qf.gank.http.client.RetrofitClient
import com.qf.gank.http.result.ApiArticleResult

/**
 * 作者：PeterWu
 * 时间：2020/7/21
 * 描述：HomePageRepository
 */
class HomePageRepository {

    suspend fun getArticleResult(type: String) : ApiArticleResult<List<ArticleBean>> {
        if (type == "Girl") {
            return RetrofitClient.getService.getGirls(type, type, 1, 20).getResult()
        } else {
            return RetrofitClient.getService.getGirls("GanHuo", type, 1, 20).getResult()
        }
    }
}