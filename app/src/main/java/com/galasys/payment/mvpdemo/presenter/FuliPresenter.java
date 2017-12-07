package com.galasys.payment.mvpdemo.presenter;

import com.galasys.payment.mvpdemo.bean.FuLiBean;
import com.galasys.payment.mvpdemo.contract.FuliContract;
import com.galasys.payment.mvpdemo.model.FuliModel;

import java.util.List;

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

public class FuliPresenter implements FuliContract.Presenter ,FuliModel.FuLiCallBack{
    FuliModel fuliModel;
    FuliContract.View view;

    public FuliPresenter(  FuliContract.View view) {
        this.view = view;
        fuliModel=new FuliModel();
    }

    @Override
    public void P_GetFuLi() {
        fuliModel.M_GetFuLi(this);
    }

    /**
     * 接口成功回调数据
     *
     * @param subjects 返回数据集合
     */
    @Override
    public void onSuccess(List<FuLiBean.ResultsBean> subjects) {
        view.V_GetFuLiOK(subjects);
    }

    /**
     * 接口返回失败的回调
     *
     * @param Err
     */
    @Override
    public void onError(String Err) {
    }
}
