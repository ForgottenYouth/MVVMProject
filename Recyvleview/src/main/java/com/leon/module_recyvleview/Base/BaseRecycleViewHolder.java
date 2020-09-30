/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: BaseRecycleViewHolder
 * Author: shiwenliang
 * Date: 2020/9/28 10:57
 * Description:
 */
package com.leon.module_recyvleview.Base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseRecycleViewHolder extends RecyclerView.ViewHolder {

    private BaseCustomView baseCustomView;

    public BaseRecycleViewHolder(@NonNull BaseCustomView itemView) {
        super((View) itemView);
        baseCustomView = itemView;
    }

    public void bindViewModel(BaseViewModel viewModel) {
        baseCustomView.loadData(viewModel);
    }
}