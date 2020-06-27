package com.qf.gank.application

import android.app.Activity

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：ActivityManager
 */
object ActivityManager {

    val activities = mutableListOf<Activity>()

    /**
     * finish指定的一个或多个Activity
     */
    fun finish(vararg clazz: Class<out Activity>) {
        activities.forEach { activiy ->
            if (clazz.contains(activiy::class.java)) {
                activiy.finish()
            }
        }
    }
}