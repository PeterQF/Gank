package com.qf.gank.utils

import android.util.Log
import com.qf.gank.BuildConfig
import com.qf.gank.application.App


/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：LogUtils
 */
object LogUtils {

    private val DEBUG_MODE by lazy {
        BuildConfig.DEBUG
    }

    fun error(msg: String) {
        if (DEBUG_MODE){
            Log.e(App.instance.packageName, msg)
        }
    }

    fun info(msg: String) {
        if (DEBUG_MODE){
            Log.i(App.instance.packageName, msg)
        }
    }

    fun debug(msg: String) {
        if (DEBUG_MODE) {
            Log.d(App.instance.packageName, msg)
        }
    }

    fun verbose(msg: String) {
        if (DEBUG_MODE){
            Log.v(App.instance.packageName, msg)
        }
    }
}