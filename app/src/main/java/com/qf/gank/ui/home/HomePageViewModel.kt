package com.qf.gank.ui.home

import androidx.lifecycle.MutableLiveData
import com.qf.gank.bean.article.ArticleBean
import com.qf.gank.ui.base.BaseViewModel

/**
 * 作者：PeterWu
 * 时间：2020/7/12
 * 描述：HomePageViewModel
 */
class HomePageViewModel : BaseViewModel() {

    private val homePageRepository by lazy { HomePageRepository() }

    val mArticleLiveData by lazy { MutableLiveData<List<ArticleBean>>() }

    fun getArticle(type: String) {
        launch(
            block = {
                val articleResult = homePageRepository.getArticleResult(type)
                val articles = articleResult.data
                if (type == "Girl") {
                    articles?.map { it.itemType = HomePageListAdapter.TYPE_GIRL }
                }
                mArticleLiveData.postValue(articles)
            }
        )
    }

}