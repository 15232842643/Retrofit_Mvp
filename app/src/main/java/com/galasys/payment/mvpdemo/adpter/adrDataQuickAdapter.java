package com.galasys.payment.mvpdemo.adpter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.galasys.payment.mvpdemo.R;
import com.galasys.payment.mvpdemo.bean.GetAndroidData;

import java.util.List;

import static com.galasys.payment.mvpdemo.R.id.item_img;

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

public class adrDataQuickAdapter extends BaseItemDraggableAdapter<GetAndroidData.ResultsBean,BaseViewHolder> {

    Context context;

    public adrDataQuickAdapter(@LayoutRes int layoutResId, @Nullable List<GetAndroidData.ResultsBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper,GetAndroidData.ResultsBean item) {

        helper.setText(R.id.item_order,item.createdAt);
        helper.setText(R.id.item_type, item.type);
        helper.setText(R.id.item_desc,item.desc);
        helper.setText(R.id.item_who,item.who);
        helper.setText(R.id.item_url,item.url);
        Glide.with(context).load(R.mipmap.ic_launcher_round).into((ImageView) helper.getView(item_img));
        helper.addOnClickListener(R.id.item_url);
    }

}