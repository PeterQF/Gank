package com.qf.gank.ui.main

import androidx.lifecycle.MutableLiveData
import com.qf.gank.bean.banner.BannerBean
import com.qf.gank.ui.base.BaseViewModel

/**
 * 作者：PeterWu
 * 时间：2020/6/29
 * 描述：MainViewModel
 */
class MainViewModel : BaseViewModel() {

    private val mainRepository by lazy { MainRepository() }

}