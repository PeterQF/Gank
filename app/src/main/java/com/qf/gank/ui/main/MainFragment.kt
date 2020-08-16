package com.qf.gank.ui.main

import com.gyf.immersionbar.ImmersionBar
import com.qf.gank.R
import com.qf.gank.ui.base.BaseVmFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * 作者：PeterWu
 * 时间：2020/7/6
 * 描述：MainFragment
 */
class MainFragment : BaseVmFragment<MainFgViewModel>() {
    override fun viewModelClass() = MainFgViewModel::class.java

    override fun initView() {
        mMenuIv.setOnClickListener {
            getShareViewModel()?.openOrCloseDrawer?.postValue(true)
        }

    }

    override fun initStatusBar() {
        ImmersionBar.with(this).titleBar(mToolbar).statusBarDarkFont(true).init()
    }

    override fun getLayoutId() = R.layout.fragment_main
}