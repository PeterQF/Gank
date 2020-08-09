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

    fun getArticle(isRefresh: Boolean, type: String, articleLiveData: MutableLiveData<MutableList<ArticleBean>>) {
        if (isRefresh) {
            getArticleResult(true, type, 1, articleLiveData)
        } else {
            getArticleResult(false, type, ++pageNum, articleLiveData)
        }
    }

    fun getArticleResult(isRefresh: Boolean, type: String, page: Int, articleLiveData: MutableLiveData<MutableList<ArticleBean>>) {
        launch(
            block = {
                var articleResult: ApiArticleResult<List<ArticleBean>>?= null
                if (type == "Girl") {
                    articleResult = RetrofitClient.getService.getGirls(type, type, page, 20).getResult()
                } else {
                    articleResult = RetrofitClient.getService.getGirls("GanHuo", type, page, 20).getResult()
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