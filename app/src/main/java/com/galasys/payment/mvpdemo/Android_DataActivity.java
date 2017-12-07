package com.galasys.payment.mvpdemo;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.galasys.payment.mvpdemo.adpter.adrDataQuickAdapter;
import com.galasys.payment.mvpdemo.bean.GetAndroidData;
import com.galasys.payment.mvpdemo.contract.AndroidDataContract;
import com.galasys.payment.mvpdemo.presenter.AndroidDataPresenter;

import java.util.ArrayList;
import java.util.List;

public class Android_DataActivity extends AppCompatActivity implements AndroidDataContract.View  {
    AndroidDataPresenter mainPresenter;
    RecyclerView recyclerView;
    //适配器
    public adrDataQuickAdapter quickAdapter;
    //数据
    List<GetAndroidData.ResultsBean> subjects;
    //android data
    //条数起止数
    //总条数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }

    private void initView() {
        subjects = new ArrayList<>();
        mainPresenter = new AndroidDataPresenter(this);
        //获取接口数据
        mainPresenter.getAndroidData();
        recyclerView = (RecyclerView) findViewById(R.id.main_rc);
        quickAdapter = new adrDataQuickAdapter(R.layout.android_data_item, subjects, Android_DataActivity.this);
        quickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        //注意:如果有空布局必须绑定recyclerVeiw否则为空
        //绑定Adapter
        quickAdapter.bindToRecyclerView(recyclerView);
        //显示布局风格
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置空布局
        quickAdapter.setEmptyView(R.layout.empty);
        //滑动删除
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(quickAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        /**
         * 拖拽的监听事件
         */
        OnItemDragListener onItemDragListener = new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
            }
        };
        /**
         * 滑动删除的监听事件
         */
        OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {

            }
        };

        // 开启拖拽
        quickAdapter.enableDragItem(itemTouchHelper, R.id.item_img, true);
        quickAdapter.setOnItemDragListener(onItemDragListener);

        // 开启滑动删除
        quickAdapter.enableSwipeItem();
        quickAdapter.setOnItemSwipeListener(onItemSwipeListener);

        recyclerView.setAdapter(quickAdapter);

    }

    /**
     * 事件处理
     */
    private void initData() {
        quickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //吐司
                Snackbar.make(view, position + "----嘿嘿嘿", 0).show();
            }
        });
        quickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.item_img:
                        Snackbar.make(view, position + "----我是图片", 0).show();
                        break;
                    case R.id.item_url:
                        Intent intent = new Intent(Android_DataActivity.this, WebViewActivity.class);
                        intent.putExtra("url", ((TextView) view.findViewById(R.id.item_url)).getText().toString());
                        startActivity(intent);
                        break;
                    default:
                }

            }
        });
    }


    @Override
    public void getAndroidDataErr(String err) {
        Toast.makeText(this, "失败了" + err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAndroidDataOK(List<GetAndroidData.ResultsBean> resultsBeanList) {
        this.subjects.addAll(resultsBeanList);
        quickAdapter.setNewData(this.subjects);
        quickAdapter.notifyDataSetChanged();
    }

}
