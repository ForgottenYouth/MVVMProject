/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: TitleView
 * Author: shiwenliang
 * Date: 2020/9/28 10:43
 * Description: 仅标题的自定义view
 */
package com.leon.module_recyvleview.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;

import com.leon.module_recyvleview.R;
import com.leon.module_recyvleview.Base.BaseCustomView;
import com.leon.module_recyvleview.databinding.ListitemNoimageLayoutBinding;

public class NoImageItemView extends LinearLayout implements BaseCustomView<NoImageItemViewModel> {

    ListitemNoimageLayoutBinding binding;

    private NoImageItemViewModel viewModel;

    public NoImageItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = DataBindingUtil.inflate(inflater, R.layout.listitem_noimage_layout,this,false);
        addView(binding.getRoot());
    }


    @Override
    public void loadData(NoImageItemViewModel data) {
        viewModel = data;
        binding.executePendingBindings();
        binding.setViewModel(data);
    }
}