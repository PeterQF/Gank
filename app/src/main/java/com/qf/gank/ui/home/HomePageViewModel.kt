package com.qf.gank.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qf.gank.bean.article.ArticleBean
import com.qf.gank.ui.base.BaseViewModel

/**
 * 作者：PeterWu
 * 时间：2020/7/12
 * 描述：HomePageViewModel
 */
class HomePageViewModel : BaseViewModel() {

    private val homePageRepository by lazy { HomePageRepository(viewModelScope, errorLiveData) }

    val mArticleLiveData by lazy { MutableLiveData<MutableList<ArticleBean>>() }

    fun getArticle(isRefresh: Boolean, type: String) {
        homePageRepository.getArticle(isRefresh, type, mArticleLiveData)
    }
}