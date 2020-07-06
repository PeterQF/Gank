package com.qf.gank.application

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：App
 */
class App : Application(), ViewModelStoreOwner {

     // tip：可借助 Application 来管理一个应用级 的 SharedViewModel，
    // 实现全应用范围内的 生命周期安全 且 事件源可追溯的 视图控制器 事件通知。

    private lateinit var mAppViewModelStore: ViewModelStore

    private var mFactory: ViewModelProvider.Factory? = null

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        registerActivityCallbacks()
        mAppViewModelStore = ViewModelStore()
    }

    fun getAppViewModelProvider(activity: Activity): ViewModelProvider? {
        return ViewModelProvider(
            activity.applicationContext as App,
            (activity.applicationContext as App).getAppFactory(activity)
        )
    }
    private fun getAppFactory(activity: Activity): ViewModelProvider.Factory {
        val application: Application = checkApplication(activity)
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        }
        return mFactory!!
    }

    private fun checkApplication(activity: Activity): Application {
        return activity.application
            ?: throw IllegalStateException(
                "Your activity/fragment is not yet attached to "
                        + "Application. You can't request ViewModel before onCreate call."
            )
    }

    private fun checkActivity(fragment: Fragment): Activity? {
        return fragment.activity
            ?: throw java.lang.IllegalStateException("Can't create ViewModelProvider for detached fragment")
    }

    private fun registerActivityCallbacks() {
        registerActivityLifecycleCallbacks(ActivityLifecycleCallbacksAdapter(
            onActivityCreated = { activity, _ ->
                ActivityManager.activities.add(activity)
            },
            onActivityDestroyed = { activity ->
                ActivityManager.activities.remove(activity)
            }
        ))

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        instance = this
    }

    override fun getViewModelStore() = mAppViewModelStore
}