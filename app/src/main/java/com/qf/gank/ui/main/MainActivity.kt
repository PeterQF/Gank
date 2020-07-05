package com.qf.gank.ui.main

import androidx.lifecycle.Observer
import com.qf.gank.R
import com.qf.gank.ui.base.BaseVmActivity
import com.qf.gank.utils.LogUtils

class MainActivity : BaseVmActivity<MainViewModel>() {

    override fun viewModelClass() = MainViewModel::class.java

    override fun initView() {}

    override fun initData() {
        mViewModel.getBanner()
    }

    override fun observe() {
        super.observe()
        mViewModel.mBannerLiveData.observe(this, Observer {
            LogUtils.info("get banner success ---> $it")
        })

    }

    override fun getLayoutId() = R.layout.fragment_drawer
}