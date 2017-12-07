package com.galasys.payment.mvpdemo.api;

import com.galasys.payment.mvpdemo.adpter.DouBanBean;
import com.galasys.payment.mvpdemo.bean.FuLiBean;
import com.galasys.payment.mvpdemo.bean.GetAndroidData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * 项目名称：MyApplication
 * 类名称：
 * 类描述：生名所有接口的类  并返回每个接口的call对象
 * 创建人：zxh
 * 创建时间：2017/11/12 14:20
 * 修改人：zxh
 * 修改时间：2017/11/12 14:20
 * 修改备注：
 */

/**
 * 接口管理类
 * 声明接口的请求方式 格式:get/post +请求的方法名
 *
 * @Query 拼接参数的关键字
 */
public interface ApiService {
    /**
     * 获取电影条目接口
     *
     * @param start 开始数
     * @param count 加载条目
     * @return //api/data/Android/10/1
     */
    @Headers({"url_Movie:movie"})
    @GET("v2/movie/top250?")
    Call<DouBanBean> getMovie(@Query("start") String start, @Query("count") String count);

    @Headers({"url_ganhuo:android"})
    @GET("data/Android/10/1")
    Call<GetAndroidData> getAndroidData();

    @Headers({"url_ganhuo:fuli"})
    @GET("data/福利/10/1")
    Call<FuLiBean> getFuliData();
}
