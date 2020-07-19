package com.qf.gank.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.qf.gank.R
import com.qf.gank.ui.base.BaseVmFragment
import kotlinx.android.synthetic.main.include_recyclerview.*

/**
 * 作者：PeterWu
 * 时间：2020/7/12
 * 描述：HomePageFragment
 */
class HomePageFragment : BaseVmFragment<HomePageViewModel>() {

    companion object {
        fun newInstance(): HomePageFragment {
            val bundle = Bundle()
//            bundle.putInt("id", id)
            val fragment = HomePageFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun viewModelClass() = HomePageViewModel::class.java

    override fun initView() {

        val list = ArrayList<String>()
        for (i in 0 until  100) {
            list.add("第${i}个")
        }
        val mAdapter = HomePageListAdapter(list)
        mRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }


    override fun getLayoutId() = R.layout.include_recyclerview
}