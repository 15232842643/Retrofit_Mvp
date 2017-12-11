package com.galasys.payment.mvpdemo.model;

import com.galasys.payment.mvpdemo.api.ApiMannger;
import com.galasys.payment.mvpdemo.bean.FuLiBean;
import com.galasys.payment.mvpdemo.contract.FuliContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：MyApplication
 * 类名称：
 * 类描述：
 * 创建人：zxh
 * 创建时间：2017/11/30 18:09
 * 修改人：zxh
 * 修改时间：2017/11/30 18:09
 * 修改备注：
 */

public class FuliModel implements FuliContract.Model {
    @Override
    public void M_GetFuLi(final FuliModel.FuLiCallBack fuLiCallBack) {
        ApiMannger.getApiService( ).getFuliData().enqueue(new Callback<FuLiBean>() {
            @Override
            public void onResponse(Call<FuLiBean> call, Response<FuLiBean> response) {
                fuLiCallBack.onSuccess(response.body().results);
            }

            @Override
            public void onFailure(Call<FuLiBean> call, Throwable t) {
                fuLiCallBack.onError(t.getMessage().toString());
            }
        });
    }


    /**
     * 接口数据回调类
     */
    public interface FuLiCallBack {
        /**
         * 接口成功回调数据
         *
         * @param subjects 返回数据集合
         */
        void onSuccess(List<FuLiBean.ResultsBean> subjects);

        /**
         * 接口返回失败的回调
         *
         * @param Err
         */
        void onError(String Err);


    }
}
