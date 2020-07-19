package com.qf.gank.ui.main

import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.gyf.immersionbar.ImmersionBar
import com.kunminx.event.EventObserver
import com.qf.gank.R
import com.qf.gank.ui.base.BaseVmActivity
import com.qf.gank.utils.BarUtils
import com.qf.gank.utils.LogUtils
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVmActivity<MainViewModel>() {

    override fun viewModelClass() = MainViewModel::class.java

    override fun initView() {
    }

    override fun initData() {
    }

    override fun observe() {
        super.observe()

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