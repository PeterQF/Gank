package com.qf.gank.ui.home

import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.qf.gank.R

/**
 * 作者：PeterWu
 * 时间：2020/7/12
 * 描述：HomeListAdapter
 */
class HomeListAdapter(data: MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.rv_home_list_item, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        val viewPager = helper.getView<ViewPager2>(R.id.mViewPager)
        val tabLayout = helper.getView<TabLayout>(R.id.mTabLayout)
        val tabTitles = context.resources.getStringArray(R.array.HomeTabTitle)
        val fragments = ArrayList<Fragment>()
        for (i in tabTitles.indices) {
            val fragment = HomePageFragment.newInstance()
            fragments.add(fragment)
        }

        viewPager.adapter = HomePageAdapter(context as FragmentActivity, fragments)
        TabLayoutMediator(tabLayout, viewPager, false,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                val tabView = LayoutInflater.from(context).inflate(R.layout.tab_item_custom, null)
                val tabTv = tabView.findViewById<TextView>(R.id.mTabTv)
                tabTv.text = tabTitles[position]
                tab.customView = tabView
            }).attach()
    }
}