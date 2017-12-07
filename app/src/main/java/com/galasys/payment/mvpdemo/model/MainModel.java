package com.galasys.payment.mvpdemo.model;

import com.galasys.payment.mvpdemo.adpter.DouBanBean;
import com.galasys.payment.mvpdemo.api.ApiMannger;
import com.galasys.payment.mvpdemo.constanse.Constanse;
import com.galasys.payment.mvpdemo.contract.MainContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：MyApplication
 * 类名称：
 * 类描述：
 * 创建人：zxh
 * 创建时间：2017/11/12 13:32
 * 修改人：zxh
 * 修改时间：2017/11/12 13:32
 * 修改备注：
 */

/**
 * 接口实现类
 */
public class MainModel implements MainContract.Model {
    /**
     * 实现类通过APIservice 获取接口电影数据
     *
     * @param start        开始数
     * @param count        获取条目数量
     * @param dataCallBack 接口成功失败回调
     */
    @Override
    public void getMovie(String start, String count, final String type, final DataCallBack dataCallBack) {

        ApiMannger.getApiService(Constanse.MOVIE).getMovie(start, count).enqueue(new Callback<DouBanBean>() {
            @Override
            public void onResponse(Call<DouBanBean> call, Response<DouBanBean> response) {
                try {
                    if (Constanse.REFRES.equals(type)) {
                        dataCallBack.onLoad(response.body().subjects);
                    } else if (!Constanse.REFRES.equals(type)) {
                        dataCallBack.onSuccess(response.body().subjects);
                    }
                } catch (Exception e) {
                    dataCallBack.onError(Constanse.ERR);
                }


            }

            @Override
            public void onFailure(Call<DouBanBean> call, Throwable t) {
                dataCallBack.onError(t.getMessage().toString());
            }
        });

    }


    /**
     * 接口数据回调类
     */
    public interface DataCallBack {
        /**
         * 接口成功回调数据
         *
         * @param subjects 返回数据集合
         */
        void onSuccess(List<DouBanBean.SubjectsBean> subjects);

        /**
         * 刷新回调接口
         *
         * @param subjects 返回数据集合
         */
        void onLoad(List<DouBanBean.SubjectsBean> subjects);

        /**
         * 接口返回失败的回调
         *
         * @param Err
         */
        void onError(String Err);


    }

}
