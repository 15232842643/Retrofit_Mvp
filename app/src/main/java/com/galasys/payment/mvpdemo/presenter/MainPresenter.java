package com.galasys.payment.mvpdemo.presenter;

import com.galasys.payment.mvpdemo.adpter.DouBanBean;
import com.galasys.payment.mvpdemo.bean.GetAndroidData;
import com.galasys.payment.mvpdemo.contract.MainContract;
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

public class MainPresenter implements MainContract.Presenter, MainModel.DataCallBack {


    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        model = new MainModel();
    }

    /**
     * 通过modle获取电影数据
     *
     * @param star  开始条目
     * @param count 加载数量
     * @param type  类型
     */
    @Override
    public void getMovieFromModule(String star, String count, String type) {
        model.getMovie(star, count, type, this);
    }


    /**
     * @param subjects 返回数据集合
     */
    @Override
    public void onSuccess(List<DouBanBean.SubjectsBean> subjects) {
        view.getmoviePtOK(subjects);
    }

    /**
     * 刷新回调接口
     *
     * @param subjects 返回数据集合
     */
    @Override
    public void onLoad(List<DouBanBean.SubjectsBean> subjects) {
        view.getmoviePtOK_Load(subjects);

    }

    /**
     * @param Err
     */
    @Override
    public void onError(String Err) {
        view.getmoviePtErr(Err);
    }


}
