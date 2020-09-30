/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: TitleView
 * Author: shiwenliang
 * Date: 2020/9/28 10:43
 * Description: 仅标题的自定义view
 */
package com.leon.common.customrecycleitem.noimg;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.leon.base.baseview.BaseCustomView;
import com.leon.common.R;
import com.leon.common.databinding.ListitemNoimageLayoutBinding;

public class NoImageItemView extends BaseCustomView<ListitemNoimageLayoutBinding,NoImageItemViewModel> {

    public NoImageItemView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.listitem_noimage_layout;
    }

    @Override
    public void setDataToView(NoImageItemViewModel dataToView) {
            binding.setViewModel(dataToView);
    }

    @Override
    public void onViewClicked(View view) {
        Toast.makeText(getContext(),viewModel.jumpUrl,Toast.LENGTH_SHORT).show();
    }

}