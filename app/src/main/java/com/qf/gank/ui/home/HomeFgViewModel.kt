package com.qf.gank.ui.home

import androidx.lifecycle.MutableLiveData
import com.qf.gank.bean.article.ArticleBean
import com.qf.gank.bean.banner.BannerBean
import com.qf.gank.ui.base.BaseViewModel
import com.qf.gank.ui.girl.GirlRepository

/**
 * 作者：PeterWu
 * 时间：2020/7/11
 * 描述：HomeFgViewModel
 */
class HomeFgViewModel : BaseViewModel() {

    private val homeRepository by lazy { HomeRepository() }

    val mBannerLiveData: MutableLiveData<List<BannerBean>> = MutableLiveData()

    fun getBanner() {
        launch(
            block = {
                val bannerDeferred = async { homeRepository.getBanner() }
                val bannerList = bannerDeferred.await()
                mBannerLiveData.postValue(bannerList)
            }
        )
    }
}