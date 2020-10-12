/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: MainAdapter
 * Author: shiwenliang
 * Date: 2020/9/28 9:46
 * Description: 适配器
 */
package com.leon.module_recyvleview;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leon.base.recycleview.BaseRecycleViewHolder;
import com.leon.base.basecustomview.BaseViewModel;
import com.leon.common.customrecycleitem.singleimg.SingleImageItemView;
import com.leon.common.customrecycleitem.singleimg.SingleImageItemViewModel;
import com.leon.common.customrecycleitem.noimg.NoImageItemView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<BaseRecycleViewHolder> {

    private Context mContext;

    private ArrayList<BaseViewModel> mDataList = new ArrayList<>();

    public static final int DEFAULT_TYPE = 1;
    public static final int PIC_TYPE = 2;
    public static final int MUTILPIC_TYPE = 3;

    public RecycleViewAdapter(Context context) {
        mContext = context;
    }

    public void setDataList(ArrayList<BaseViewModel> mDataList) {
        this.mDataList = mDataList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataList != null && mDataList.size() != 0) {
            if (mDataList.get(position) instanceof SingleImageItemViewModel) {
                return PIC_TYPE;
            }
        }
        return DEFAULT_TYPE;
    }

    @NonNull
    @Override
    public BaseRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == PIC_TYPE) {
            return new BaseRecycleViewHolder(new SingleImageItemView(mContext));
        } else if (viewType == DEFAULT_TYPE) {
            return new BaseRecycleViewHolder(new NoImageItemView(mContext));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecycleViewHolder holder, int position) {
        holder.bindViewModel(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}