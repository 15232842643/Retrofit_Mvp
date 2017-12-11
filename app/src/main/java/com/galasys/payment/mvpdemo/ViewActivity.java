package com.galasys.payment.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gastudio.gabottleloading.library.GABottleLoadingView;

/**
 * 项目名称：MyApplication
 * 类名称：
 * 类描述：
 * 创建人：zxh
 * 创建时间：2017/12/7 14:57
 * 修改人：zxh
 * 修改时间：2017/12/7 14:57
 * 修改备注：
 */

public class ViewActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout);
        ((GABottleLoadingView) findViewById(R.id.ga_bottle_loading_view)).performAnimation();
    }
}
