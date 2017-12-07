package com.galasys.payment.mvpdemo.adpter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.galasys.payment.mvpdemo.R;
import com.galasys.payment.mvpdemo.bean.FuLiBean;

import java.util.List;

/**
 * 项目名称：MyApplication
 * 类名称：
 * 类描述：
 * 创建人：zxh
 * 创建时间：2017/11/12 18:10
 * 修改人：zxh
 * 修改时间：2017/11/12 18:10
 * 修改备注：
 *
 * @author zxh
 */

public class FuLiQuickAdapter extends BaseItemDraggableAdapter<FuLiBean.ResultsBean, BaseViewHolder> {

    Context context;

    public FuLiQuickAdapter(@LayoutRes int layoutResId, @Nullable List<FuLiBean.ResultsBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FuLiBean.ResultsBean item) {

        Glide.with(context).load(item.url).into((ImageView) helper.getView(R.id.item_img));
        helper.addOnClickListener(R.id.item_img);
    }

}