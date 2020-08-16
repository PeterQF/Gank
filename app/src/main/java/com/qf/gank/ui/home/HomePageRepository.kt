package com.qf.gank.ui.home

import androidx.lifecycle.MutableLiveData
import com.qf.gank.bean.article.ArticleBean
import com.qf.gank.http.client.RetrofitClient
import com.qf.gank.http.exception.ApiException
import com.qf.gank.http.result.ApiArticleResult
import com.qf.gank.ui.base.BaseRepository
import com.qf.gank.utils.LogUtils
import kotlinx.coroutines.CoroutineScope

/**
 * 作者：PeterWu
 * 时间：2020/7/21
 * 描述：HomePageRepository
 */
class HomePageRepository(
    coroutineScope: CoroutineScope,
    errorLiveData: MutableLiveData<ApiException>
) : BaseRepository(coroutineScope, errorLiveData) {


    /**
     * 页码
     */
    private var pageNum = 1

    /**
     * 获取文章
     */
    fun getArticle(isRefresh: Boolean, type: String, articleLiveData: MutableLiveData<MutableList<ArticleBean>>) {
        if (isRefresh) {
            requestArticle(true, type, 1, articleLiveData)
        } else {
            requestArticle(false, type, ++pageNum, articleLiveData)
        }
    }

    /**
     * 请求文章
     */
    private fun requestArticle(isRefresh: Boolean, type: String, page: Int, articleLiveData: MutableLiveData<MutableList<ArticleBean>>) {
        launch(
            block = {
                var articleResult: ApiArticleResult<List<ArticleBean>>?= null
                articleResult = if (type == "Girl") {
                    RetrofitClient.getService.getArticle(type, type, page, 20).getResult()
                } else {
                    RetrofitClient.getService.getArticle("GanHuo", type, page, 20).getResult()
                }
                val articles = articleResult.data
                if (type == "Girl") {
                    articles?.map { it.itemType = HomePageListAdapter.TYPE_GIRL }
                }
                articles
            },
            success = {
                articleLiveData.value.apply {
                    val resultList = if (isRefresh || this == null) {
                        mutableListOf()
                    } else {
                        this
                    }
                    LogUtils.error("Get article list ---> ${it?.size}")
                    it?.let { result ->
                        if (result.count() == 0) {
                            articleLiveData.postValue(mutableListOf())
                        } else {
                            resultList.addAll(result)
                            articleLiveData.postValue(resultList)
                        }
                    }
                }
            }
        )
    }
}