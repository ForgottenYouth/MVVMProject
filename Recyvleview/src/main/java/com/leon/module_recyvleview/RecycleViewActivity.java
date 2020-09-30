/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: RecycleViewActivity
 * Author: shiwenliang
 * Date: 2020/9/28 16:40
 * Description: 列表视图
 */
package com.leon.module_recyvleview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.leon.base.baseviewmodel.BaseViewModel;
import com.leon.base.mvvm.model.IBaseModelListener;
import com.leon.base.mvvm.model.PagingResult;

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
        recycleView = findViewById(R.id.recyclerview);
        mainAdapter = new RecycleViewAdapter(this);
        model = new RecycleViewActivityModel(this);

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
    public void onLoadFailure(String message) {

    }
}