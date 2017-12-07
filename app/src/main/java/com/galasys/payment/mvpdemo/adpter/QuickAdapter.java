package com.galasys.payment.mvpdemo.adpter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.galasys.payment.mvpdemo.R;

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
 * @author zxh
 */

public class QuickAdapter extends BaseItemDraggableAdapter<DouBanBean.SubjectsBean,BaseViewHolder> {

    Context context;

    public QuickAdapter(@LayoutRes int layoutResId, @Nullable List<DouBanBean.SubjectsBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DouBanBean.SubjectsBean item) {
        helper.setText(R.id.item_order, item.year);
        helper.setText(R.id.item_info, item.title);
        Glide.with(context).load(item.images.large).into((ImageView) helper.getView(R.id.item_img));
        helper.addOnClickListener(R.id.item_img);
        helper.addOnClickListener(R.id.item_info);
    }

}