/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: BaseCustomView
 * Author: shiwenliang
 * Date: 2020/9/30 9:27
 * Description:
 */
package com.leon.base.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.leon.base.baseviewmodel.BaseViewModel;

public abstract class BaseCustomView<VBINDING extends ViewDataBinding, VMODEL extends BaseViewModel>
        extends LinearLayout
        implements IBaseCustomView<VMODEL> {

    protected VBINDING binding;
    protected VMODEL viewModel;

    public BaseCustomView(Context context) {
        super(context);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BaseCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), this, false);
        binding.getRoot().setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked(v);
            }
        });
        addView(binding.getRoot());
    }

    public abstract int getLayoutId();

    @Override
    public void setData(VMODEL data) {
        setDataToView(data);
        viewModel = data;
        binding.executePendingBindings();
    }

    public abstract void setDataToView(VMODEL dataToView);

    public abstract void onViewClicked(View view);
}