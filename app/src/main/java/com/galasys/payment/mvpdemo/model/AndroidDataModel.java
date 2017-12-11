package com.galasys.payment.mvpdemo.model;

import com.galasys.payment.mvpdemo.adpter.DouBanBean;
import com.galasys.payment.mvpdemo.api.ApiMannger;
import com.galasys.payment.mvpdemo.bean.GetAndroidData;
import com.galasys.payment.mvpdemo.contract.AndroidDataContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：MyApplication
 * 类名称：
 * 类描述：
 * 创建人：zxh
 * 创建时间：2017/11/30 17:39
 * 修改人：zxh
 * 修改时间：2017/11/30 17:39
 * 修改备注：
 */

public class AndroidDataModel implements AndroidDataContract.Model {

    @Override
    public void getAndroidData(final AndroidDataCallBack dataCallBack) {
        ApiMannger.getApiService( ).getAndroidData().enqueue(new Callback<GetAndroidData>() {
            @Override
            public void onResponse(Call<GetAndroidData> call, Response<GetAndroidData> response) {
                dataCallBack.onSuccessAndroid(response.body().getResults());
            }

            @Override
            public void onFailure(Call<GetAndroidData> call, Throwable t) {
                dataCallBack.onErrAndroid(t.getMessage().toString());
            }
        });
    }


    /**
     * 接口数据回调类
     */
    public interface AndroidDataCallBack {

        /**
         * 刷新回调接口
         *
         * @param subjects 返回数据集合
         */
        void onLoad(List<DouBanBean.SubjectsBean> subjects);

        void onSuccessAndroid(List<GetAndroidData.ResultsBean> resultsBeanList);

        void onErrAndroid(String err);
    }
}
