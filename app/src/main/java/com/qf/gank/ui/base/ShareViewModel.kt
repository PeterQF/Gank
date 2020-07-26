package com.qf.gank.ui.base

import com.kunminx.event.EventLiveData

/**
 * 作者：PeterWu
 * 时间：2020/7/6
 * 描述：ShareViewModel
 */
class ShareViewModel : BaseViewModel() {

    val openOrCloseDrawer: EventLiveData<Boolean> = EventLiveData()

    val isGetCategory: EventLiveData<Boolean> = EventLiveData()
}