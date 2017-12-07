package com.galasys.payment.mvpdemo.api;

import com.galasys.payment.mvpdemo.constanse.Constanse;
import com.galasys.payment.mvpdemo.utils.HttpLogIntercepter;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：MyApplication
 * 类名称：
 * 类描述：ApiMannger 主要是提供一个实例化Apiservice对象的一个类
 * 创建人：zxh
 * 创建时间：2017/11/12 14:35
 * 修改人：zxh
 * 修改时间：2017/11/12 14:35
 * 修改备注：
 */

public class ApiMannger {
    /**
     * 1 获取retrofit对象
     * 2 设置主域名
     * 3 执行
     * 4 获取APi接口实现类的实例对象
     * 返回ApiService对象
     *
     * @return
     */

    public static ApiService getApiService(String newBaseUrl) {
        Constanse.BaseUrl=newBaseUrl;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpLoggingInterceptor(new HttpLogIntercepter()));
      //  builder.addInterceptor(new ApiInterceptor());
        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl(Constanse.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(ApiService.class);

    }

    public static ApiService getApiService_2() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpLoggingInterceptor(new HttpLogIntercepter()));
        OkHttpClient okHttpClient = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constanse.GANK)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(ApiService.class);

    }

    public static ApiService getApiService_3() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpLoggingInterceptor(new HttpLogIntercepter()));
        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(ApiService.class);

    }

}
