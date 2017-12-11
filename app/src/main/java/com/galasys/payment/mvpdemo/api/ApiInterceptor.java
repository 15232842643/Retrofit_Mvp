package com.galasys.payment.mvpdemo.api;

import android.util.Log;

import com.galasys.payment.mvpdemo.constanse.Constanse;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名称：MyApplication
 * 类名称：
 * 类描述：
 * 创建人：zxh
 * 创建时间：2017/12/6 11:40
 * 修改人：zxh
 * 修改时间：2017/12/6 11:40
 * 修改备注：
 */

public class ApiInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取request
        Request request = chain.request();
        //获取request的创建者builder
        Request.Builder builder = request.newBuilder();
        //从request中获取headers，通过给定的键url_name
        List<String> headerValues = request.headers("retrofitUrl");
        if (headerValues != null && headerValues.size() > 0) {
            //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
            builder.removeHeader(HttpConfig.RETROFITURL);

            //匹配获得新的BaseUrl
            String headerValue = headerValues.get(0);
            HttpUrl newBaseUrl = null;
            HttpUrl oldHttpUrl = null;
            Log.d("ApiInterceptor", headerValue);
            if ("fuli".equals(headerValue)) {
                newBaseUrl = HttpUrl.parse(Constanse.GANK);
            } else if ("android".equals(headerValue)) {
                newBaseUrl = HttpUrl.parse(Constanse.GANK);
            } else if ("movie".equals(headerValue)) {
                newBaseUrl = HttpUrl.parse(Constanse.MOVIE);
            } else {
                newBaseUrl = oldHttpUrl;
            }
            Constanse.BaseUrl = String.valueOf(newBaseUrl);
            //从request中获取原有的HttpUrl实例oldHttpUrl
            oldHttpUrl = request.url();
            //重建新的HttpUrl，修改需要修改的url部分
            HttpUrl newFullUrl = oldHttpUrl
                    .newBuilder()
                    .scheme(newBaseUrl.scheme())
                    .host(newBaseUrl.host())
                    .port(newBaseUrl.port())
                    .build();

            //重建这个request，通过builder.url(newFullUrl).build()；
            //然后返回一个response至此结束修改
            return chain.proceed(builder.url(newFullUrl).build());
        } else {
            return chain.proceed(request);
        }
    }
}
