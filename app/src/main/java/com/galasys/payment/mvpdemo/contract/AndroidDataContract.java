package com.galasys.payment.mvpdemo.contract;

import com.galasys.payment.mvpdemo.bean.GetAndroidData;
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

public interface AndroidDataContract {
    interface Model {
        void getAndroidData(AndroidDataModel.AndroidDataCallBack dataCallBack);
    }

    interface View {
        void getAndroidDataErr(String err);

        void getAndroidDataOK(List<GetAndroidData.ResultsBean> resultsBeanList);
    }

    interface Presenter {
        void getAndroidData();
    }
}
