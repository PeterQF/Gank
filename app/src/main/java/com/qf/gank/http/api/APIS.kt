package com.qf.gank.http.api

import com.qf.gank.bean.article.ArticleBean
import com.qf.gank.bean.banner.BannerBean
import com.qf.gank.http.result.ApiArticleResult
import com.qf.gank.http.result.ApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：APIS
 */
interface APIS {

    /**
     * 获取banner
     */
    @GET("banners")
    suspend fun getBanners(): ApiResult<List<BannerBean>>

    /**
     * 获取妹子图
     */
    @GET("data/category/{category}/type/{type}/page/{page}/count/{count}")
    suspend fun getGirls(
        @Path("category") category: String,
        @Path("type") type: String,
        @Path("page") page: Int,
        @Path("count") count: Int
    ): ApiArticleResult<List<ArticleBean>>
}