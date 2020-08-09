package com.qf.gank.ui.home

import androidx.lifecycle.MutableLiveData
import com.qf.gank.bean.banner.BannerBean
import com.qf.gank.bean.category.CategoryBean
import com.qf.gank.http.client.RetrofitClient
import com.qf.gank.http.exception.ApiException
import com.qf.gank.ui.base.BaseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 作者：PeterWu
 * 时间：2020/7/11
 * 描述：HomeRepository
 */
class HomeRepository(coroutineScope: CoroutineScope, errorLiveData: MutableLiveData<ApiException>) :
    BaseRepository(coroutineScope, errorLiveData) {

    fun getBanner(bannerLiveData: MutableLiveData<List<BannerBean>>) {
        launch(
            block = {
                RetrofitClient.getService.getBanners().apiData()
            },
            success = {
                bannerLiveData.postValue(it)
            }
        )
    }

    fun getCategory(categoryLiveData: MutableLiveData<List<CategoryBean>>) {
        launch(
            block = {
                val girlCategory = async { RetrofitClient.getService.getCategory("Girl").apiData() }.await()
                val articleCategory = async { RetrofitClient.getService.getCategory("Article").apiData() }.await()
                ArrayList<CategoryBean>().apply {
                    girlCategory?.let { addAll(it) }
                    articleCategory?.let { addAll(it) }
                }
            },
            success = {
                categoryLiveData.postValue(it)
            }
        )
    }
}