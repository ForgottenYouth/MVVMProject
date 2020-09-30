/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: BaseRecycleViewHolder
 * Author: shiwenliang
 * Date: 2020/9/28 10:57
 * Description:
 */
package com.leon.base.baseviewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leon.base.baseviewmodel.BaseViewModel;
import com.leon.base.baseview.IBaseCustomView;

public class BaseRecycleViewHolder extends RecyclerView.ViewHolder {

    private IBaseCustomView baseCustomView;

    public BaseRecycleViewHolder(@NonNull IBaseCustomView itemView) {
        super((View) itemView);
        baseCustomView = itemView;
    }

    public void bindViewModel(BaseViewModel viewModel) {
        baseCustomView.setData(viewModel);
    }
}