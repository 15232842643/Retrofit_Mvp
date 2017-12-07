package com.galasys.payment.mvpdemo.contract;

import com.galasys.payment.mvpdemo.bean.FuLiBean;
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

public interface FuliContract {
    interface Model {

        void M_GetFuLi(FuliModel.FuLiCallBack fuLiCallBack);
    }

    interface View {

        void V_GetFuLiOK(List<FuLiBean.ResultsBean> subjects);
    }

    interface Presenter {
        void P_GetFuLi();
    }
}
