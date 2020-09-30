/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: PicTitleView
 * Author: shiwenliang
 * Date: 2020/9/28 14:58
 * Description:
 */
package com.leon.module_recyvleview.customviews;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.leon.module_recyvleview.R;
import com.leon.module_recyvleview.Base.BaseCustomView;
import com.leon.module_recyvleview.databinding.ListitemSingleimageLayoutBinding;

public class SingleImageItemView extends LinearLayout implements BaseCustomView<SingleImageItemViewModel> {

    ListitemSingleimageLayoutBinding binding;

    SingleImageItemViewModel viewModel;

    public SingleImageItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = DataBindingUtil.inflate(inflater, R.layout.listitem_singleimage_layout,this,false);
        addView(binding.getRoot());
    }


    @Override
    public void loadData(SingleImageItemViewModel model){
        binding.setViewmodel(model);
        binding.executePendingBindings();
        viewModel=model;
    }

    @BindingAdapter("loadimageurl")
    public static void loadimageurl(ImageView imageView, String picUrl) {
        if (!TextUtils.isEmpty(picUrl)) {
            Glide.with(imageView).asBitmap().load(picUrl).into(imageView);
        }
    }
}