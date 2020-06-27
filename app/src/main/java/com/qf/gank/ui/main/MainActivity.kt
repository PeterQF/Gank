package com.qf.gank.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qf.gank.R
import com.qf.gank.bean.banner.BannerBean
import com.qf.gank.ext.launch
import com.qf.gank.http.client.RetrofitClient
import com.qf.gank.http.result.ApiResult
import com.qf.gank.utils.LogUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitClient
            .getService
            .getBanners()
            .enqueue(object : Callback<ApiResult<List<BannerBean>>> {
                override fun onFailure(call: Call<ApiResult<List<BannerBean>>>, t: Throwable) {
                    LogUtils.info("get banner failed ---> ${t.printStackTrace()}")
                }

                override fun onResponse(
                    call: Call<ApiResult<List<BannerBean>>>,
                    response: Response<ApiResult<List<BannerBean>>>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()?.status == 100) {
                            LogUtils.info("get banner success ---> ${response.body()?.apiData()}")
                        }
                    }
                }

            })
    }
}