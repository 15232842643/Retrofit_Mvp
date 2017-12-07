package com.galasys.payment.mvpdemo;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.galasys.payment.mvpdemo.adpter.DouBanBean;
import com.galasys.payment.mvpdemo.adpter.QuickAdapter;
import com.galasys.payment.mvpdemo.constanse.Constanse;
import com.galasys.payment.mvpdemo.contract.MainContract;
import com.galasys.payment.mvpdemo.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, BaseQuickAdapter.RequestLoadMoreListener {
    MainPresenter mainPresenter;
    RecyclerView recyclerView;
    //适配器
    public QuickAdapter quickAdapter;
    //数据
    List<DouBanBean.SubjectsBean> subjects;
    //条数起止数
    private int mCurrentCounter = 0;
    //总条数
    private int TOTAL_COUNTER = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }
    private void initView() {
        subjects = new ArrayList<>();
        mainPresenter = new MainPresenter(this);
        //获取接口数据
        mainPresenter.getMovieFromModule(String.valueOf(mCurrentCounter), String.valueOf(10), "");
        recyclerView = (RecyclerView) findViewById(R.id.main_rc);
        quickAdapter = new QuickAdapter(R.layout.item, subjects, MainActivity.this);
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

     //   View view=getLayoutInflater().inflate(R.layout.empty,null);
       // 添加头部
//        quickAdapter.addHeaderView(getView());
//        //添加尾部
//        quickAdapter.addFooterView(getView());
//        //删除指定view
//        quickAdapter.removeHeaderView(view);
//        quickAdapter.removeFooterView(view);

        //设置下拉监听事件
        quickAdapter.setOnLoadMoreListener(this, recyclerView);
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
                Snackbar.make(view,position+"----嘿嘿嘿",0).show();
            }
        });
        quickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.item_img:
                        Snackbar.make(view,position+"----我是图片",0).show();
                        break;
                    case R.id.item_info:
                        Snackbar.make(view,position+"----"+ ((TextView) (view.findViewById(R.id.item_info))).getText().toString(),0).show();
                        break;
                    default:
                }

            }
        });
    }

    /**
     * @param subjects
     */
    @Override
    public void getmoviePtOK(List<DouBanBean.SubjectsBean> subjects) {
        //把list集合中的bean全加入新的集合中
        this.subjects.addAll(subjects);
        quickAdapter.setNewData(this.subjects);
        quickAdapter.notifyDataSetChanged();
        mCurrentCounter += 10;


    }

    /**
     * 通过presenter获取电影数据
     * 加载时回调数据
     *
     * @param subjects
     */
    @Override
    public void getmoviePtOK_Load(List<DouBanBean.SubjectsBean> subjects) {
        quickAdapter.addData(subjects);
        quickAdapter.notifyDataSetChanged();
        mCurrentCounter += 10;

    }

    @Override
    public void getmoviePtErr(String err) {
        Log.d("MainActivity", err);

        Toast.makeText(this, "失败了" + err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMoreRequested() {
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mCurrentCounter >= TOTAL_COUNTER) {
                    //数据全部加载完毕
                    quickAdapter.loadMoreEnd();
                } else {
                    //成功获取更多数据
                    mainPresenter.getMovieFromModule(String.valueOf(mCurrentCounter), String.valueOf(10), Constanse.REFRES);
                    quickAdapter.loadMoreComplete();
                }
            }

        }, 1000);
    }


}
