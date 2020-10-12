/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: RecycleViewActivity
 * Author: shiwenliang
 * Date: 2020/9/28 16:40
 * Description: 列表视图
 */
package com.leon.module_recyvleview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.leon.base.basecustomview.BaseViewModel;
import com.leon.base.mvvm.model.IBaseModelListener;
import com.leon.base.mvvm.model.PagingResult;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity implements IBaseModelListener<ArrayList<BaseViewModel>> {

    RecyclerView recycleView;
    RecycleViewAdapter mainAdapter;
    RecycleViewActivityModel model;
    ArrayList<BaseViewModel> dataList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_layout);
        init();
    }

    private void init() {
        RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        refreshLayout.setRefreshHeader(new ClassicsHeader(this));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                model.refresh();
                refreshLayout.finishRefresh(true);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                model.loadMore();
                refreshLayout.finishLoadMore(true);
            }
        });

        recycleView = findViewById(R.id.recyclerview);
        mainAdapter = new RecycleViewAdapter(this);
        model = new RecycleViewActivityModel();
        model.registListener(this);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(mLinearLayoutManager);
        recycleView.setAdapter(mainAdapter);
        model.refresh();
    }

    @Override
    public void onLoadSuccess(ArrayList<BaseViewModel> data, PagingResult... pagingResults) {
        if (data != null && pagingResults.length > 0 && pagingResults[0].isFirst) {
            dataList.clear();
        }
        dataList.addAll(data);
        mainAdapter.setDataList(dataList);
    }

    @Override
    public void onLoadFailure(String message, PagingResult... pagingResults) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}