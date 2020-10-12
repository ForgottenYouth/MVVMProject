/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: RecycleFragment
 * Author: shiwenliang
 * Date: 2020/10/12 17:46
 * Description: 列表
 */
package com.leon.module_recyvleview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.leon.base.basecustomview.BaseCustomViewModel;
import com.leon.base.mvvm.model.IBaseModelListener;
import com.leon.base.mvvm.model.PagingResult;
import com.leon.module_recyvleview.databinding.FragmentRecycleviewLayoutBinding;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class RecycleFragment extends Fragment implements IBaseModelListener<ArrayList<BaseCustomViewModel>> {

    RecycleFragmentAdapter mAdapter;
    RecycleFragmentModel model;
    ArrayList<BaseCustomViewModel> dataList = new ArrayList<>();

    FragmentRecycleviewLayoutBinding viewDataBinding;

    public static RecycleFragment newInstance(){
        RecycleFragment fragment = new RecycleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_recycleview_layout,container,false);
        init();
        return viewDataBinding.getRoot();
    }

    @Override
    public void onLoadSuccess(ArrayList<BaseCustomViewModel> data, PagingResult... pagingResults) {
        if (data != null && pagingResults.length > 0 && pagingResults[0].isFirst) {
            dataList.clear();
        }
        dataList.addAll(data);
        mAdapter.setDataList(dataList);
    }

    @Override
    public void onLoadFailure(String message, PagingResult... pagingResults) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
    }


    private void init(){
        viewDataBinding.refreshLayout.setRefreshHeader(new ClassicsHeader(this.getActivity()));
        viewDataBinding.refreshLayout.setRefreshFooter(new ClassicsFooter(this.getActivity()));
        viewDataBinding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                model.refresh();
                refreshLayout.finishRefresh(true);
            }
        });
        viewDataBinding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                model.loadMore();
                refreshLayout.finishLoadMore(true);
            }
        });

        mAdapter = new RecycleFragmentAdapter(this.getActivity());
        model = new RecycleFragmentModel();
        model.registListener(this);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this.getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        viewDataBinding.recyclerview.setLayoutManager(mLinearLayoutManager);
        viewDataBinding.recyclerview.setAdapter(mAdapter);
        model.refresh();
    }
}