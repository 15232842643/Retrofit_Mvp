package com.galasys.payment.mvpdemo.presenter;

import com.galasys.payment.mvpdemo.adpter.DouBanBean;
import com.galasys.payment.mvpdemo.bean.GetAndroidData;
import com.galasys.payment.mvpdemo.contract.AndroidDataContract;
import com.galasys.payment.mvpdemo.model.AndroidDataModel;

import java.util.List;

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

public class AndroidDataPresenter implements AndroidDataContract.Presenter ,AndroidDataModel.AndroidDataCallBack{
    AndroidDataModel model;
    AndroidDataContract.View view;

    public AndroidDataPresenter(AndroidDataContract.View view) {
        this.view = view;
        model=new AndroidDataModel();
    }

    @Override
    public void getAndroidData() {
        model.getAndroidData(this);
    }

    /**
     * 刷新回调接口
     *
     * @param subjects 返回数据集合
     */
    @Override
    public void onLoad(List<DouBanBean.SubjectsBean> subjects) {

    }

    @Override
    public void onSuccessAndroid(List<GetAndroidData.ResultsBean> resultsBeanList) {
        view.getAndroidDataOK(resultsBeanList);
    }

    @Override
    public void onErrAndroid(String err) {

    }
}
