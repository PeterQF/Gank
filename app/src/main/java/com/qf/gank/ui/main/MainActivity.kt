package com.qf.gank.ui.main

import androidx.lifecycle.Observer
import com.qf.gank.R
import com.qf.gank.ui.base.BaseVmActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVmActivity<MainViewModel>() {

    override fun viewModelClass() = MainViewModel::class.java

    override fun initView() {
    }

    override fun initData() {
    }

    override fun observe() {
        super.observe()

        getShareViewModel()?.openOrCloseDrawer?.observe(this, Observer {
            if (it) {
                mDrawerLayout.open()
            } else {
                mDrawerLayout.close()
            }
        })

    }

    override fun getLayoutId() = R.layout.activity_main
}