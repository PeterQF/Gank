package com.qf.gank.ui.main

import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.kunminx.event.EventObserver
import com.qf.gank.R
import com.qf.gank.ui.base.BaseVmActivity
import com.qf.gank.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*

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

        getShareViewModel()?.openOrCloseDrawer?.observe(this, EventObserver {
            if (it) {
                mDrawerLayout.open()
            } else {
                mDrawerLayout.close()
            }
        })

    }

    override fun getLayoutId() = R.layout.activity_main
}