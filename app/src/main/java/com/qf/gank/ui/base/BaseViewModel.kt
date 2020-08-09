package com.qf.gank.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonParseException
import com.qf.gank.R
import com.qf.gank.application.App
import com.qf.gank.ext.showToast
import com.qf.gank.ext.toast
import com.qf.gank.http.exception.ApiException
import kotlinx.coroutines.*
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

// 起个别名
//typealias Block<T> = suspend () -> T
//typealias Error = suspend (e: Exception) -> Unit
//typealias Cancel = suspend (e: Exception) -> Unit

/**
 * 作者：PeterWu
 * 时间：2020/6/27
 * 描述：BaseViewModel
 */
open class BaseViewModel : ViewModel() {

    /**
     * 错误信息liveData
     */
    val errorLiveData = MutableLiveData<ApiException>()

//    /**
//     * 创建并执行协程
//     */
//    protected fun launch(block: Block<Unit>, error: Error? = null, cancel: Cancel? = null): Job {
//        return viewModelScope.launch {
//            try {
//                block.invoke()
//            } catch (e: Exception) {
//                when(e) {
//                    is CancellationException -> cancel?.invoke(e)
//                    else -> {
//                        // 统一处理错误，比如弹一些错误的toast
//                        onError(e)
//                        // 处理错误，比如更改一些状态什么的
//                        error?.invoke(e)
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 执行并行协程
//     * 用于同时发起多个请求
//     */
//    protected fun <T> async(block: Block<T>): Deferred<T> {
//        return viewModelScope.async { block.invoke() }
//    }
//
//    /**
//     * 取消协程
//     */
//    protected fun cancelJob(job: Job?) {
//        if (job != null && job.isActive && job.isCompleted.not() && job.isCancelled.not()) {
//            job.cancel()
//        }
//    }
//
//    /**
//     * 统一处理错误
//     */
//    private fun onError(e: Exception) {
//        when(e) {
//            is ApiException -> {
//                // 可以根据不同的服务器状态来判断，由于这里服务器没有定义错误码，
//                // 所以如果状态/错误码 != 100，都认为是服务器出错
////                when(e.status) {
////                    is xxx -> {}
////                    is xxx ->
////                }
//                toast(R.string.common_server_error)
//            }
//            is ConnectException -> {
//                // 连接失败
//                toast(R.string.common_net_error)
//            }
//            is SocketTimeoutException -> {
//                // 请求超时
//                toast(R.string.common_net_time_out)
//            }
//            is JsonParseException -> {
//                // 数据解析错误
//                toast(R.string.common_json_parse_error)
//            }
//            else -> {
//                // 其他错误，总结为服务器出错
//                toast(R.string.common_server_error)
//            }
//        }
//    }
}