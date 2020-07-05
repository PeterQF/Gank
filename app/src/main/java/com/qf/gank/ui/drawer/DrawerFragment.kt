package com.qf.gank.ui.drawer

import com.qf.gank.R
import com.qf.gank.ui.base.BaseVmFragment

/**
 * 作者：PeterWu
 * 时间：2020/7/5
 * 描述：DrawerFragment
 */
class DrawerFragment : BaseVmFragment<DrawerViewModel>() {

    override fun viewModelClass() = DrawerViewModel::class.java

    override fun initView() {}

    override fun getLayoutId() = R.layout.fragment_drawer
}