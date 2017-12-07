package com.galasys.payment.mvpdemo.contract;

import com.galasys.payment.mvpdemo.adpter.DouBanBean;
import com.galasys.payment.mvpdemo.model.MainModel;

import java.util.List;

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

public interface MainContract {
    interface Model {
        /**
         * 实现类通过APIservice 获取接口电影数据
         *
         * @param start        开始数
         * @param count        获取条目数量
         * @param dataCallBack 接口成功失败回调
         */
        void getMovie(String start, String count, String type, MainModel.DataCallBack dataCallBack);


    }

    interface View {
        /**
         * 通过presenter 获取电影数据
         *
         * @param subjects
         */
        void getmoviePtOK(List<DouBanBean.SubjectsBean> subjects);

        /**
         * 通过presenter获取电影数据
         * 加载时回调数据
         *
         * @param subjects
         */
        void getmoviePtOK_Load(List<DouBanBean.SubjectsBean> subjects);

        /**
         * 如果数据访问失败 通过presenter 返回失败结果
         *
         * @param err
         */
        void getmoviePtErr(String err);


    }

    interface Presenter {
        /**
         * 通过modle获取电影数据
         *
         * @param star  开始条目
         * @param count 加载数量
         * @param type  类型
         */
        void getMovieFromModule(String star, String count, String type);

    }
}
