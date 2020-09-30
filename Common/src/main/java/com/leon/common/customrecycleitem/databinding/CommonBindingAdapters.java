/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: CommonBindingAdapters
 * Author: shiwenliang
 * Date: 2020/9/30 10:03
 * Description:
 */
package com.leon.common.customrecycleitem.databinding;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class CommonBindingAdapters {

    @BindingAdapter("loadimageurl")
    public static void loadimageurl(ImageView imageView, String picUrl) {
        if (!TextUtils.isEmpty(picUrl)) {
            Glide.with(imageView).asBitmap().load(picUrl).into(imageView);
        }
    }
}