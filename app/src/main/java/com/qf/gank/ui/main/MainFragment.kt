package com.qf.gank.ui.main

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
            getShareViewModel()?.openOrCloseDrawer?.postEvent(true)
        }
    }

    override fun getLayoutId() = R.layout.fragment_main
}