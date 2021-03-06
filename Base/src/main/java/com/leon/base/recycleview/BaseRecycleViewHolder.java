/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: BaseRecycleViewHolder
 * Author: shiwenliang
 * Date: 2020/9/28 10:57
 * Description:
 */
package com.leon.base.recycleview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leon.base.basecustomview.BaseCustomViewModel;
import com.leon.base.basecustomview.IBaseCustomView;

public class BaseRecycleViewHolder extends RecyclerView.ViewHolder {

    private IBaseCustomView baseCustomView;

    public BaseRecycleViewHolder(@NonNull IBaseCustomView itemView) {
        super((View) itemView);
        baseCustomView = itemView;
    }

    public void bindViewModel(BaseCustomViewModel viewModel) {
        baseCustomView.setData(viewModel);
    }
}