/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: MutilImgItemView
 * Author: shiwenliang
 * Date: 2020/9/28 17:51
 * Description: 多图的列表项
 */
package com.leon.common.customrecycleitem.mutilimg;

import android.content.Context;
import android.view.View;

import com.leon.base.baseview.BaseCustomView;
import com.leon.common.databinding.ListitemMutilimgLayoutBinding;

public class MutilImgItemView extends BaseCustomView<ListitemMutilimgLayoutBinding,MutilImgItemViewModel> {
    
    public MutilImgItemView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void setDataToView(MutilImgItemViewModel dataToView) {

    }

    @Override
    public void onViewClicked(View view) {

    }
}