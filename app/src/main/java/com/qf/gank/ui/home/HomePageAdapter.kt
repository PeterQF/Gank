package com.qf.gank.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * 作者：PeterWu
 * 时间：2020/7/12
 * 描述：HomePageAdapter
 */
class HomePageAdapter(fragmentActivity: FragmentActivity, private val fragments: ArrayList<Fragment>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}