/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: PicTitleView
 * Author: shiwenliang
 * Date: 2020/9/28 14:58
 * Description:
 */
package com.leon.common.customrecycleitem.singleimg;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.leon.base.basecustomview.BaseCustomView;
import com.leon.common.R;
import com.leon.common.databinding.ListitemSingleimageLayoutBinding;

public class SingleImageItemView extends BaseCustomView<ListitemSingleimageLayoutBinding,SingleImageItemViewModel> {


    public SingleImageItemView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.listitem_singleimage_layout;
    }

    @Override
    public void setDataToView(SingleImageItemViewModel dataToView) {
        binding.setViewmodel(dataToView);
    }

    @Override
    public void onViewClicked(View view) {
        Toast.makeText(getContext(),viewModel.jumpUrl,Toast.LENGTH_SHORT).show();
    }
}