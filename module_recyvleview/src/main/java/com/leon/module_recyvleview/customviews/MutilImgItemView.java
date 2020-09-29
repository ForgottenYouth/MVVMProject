/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: MutilImgItemView
 * Author: shiwenliang
 * Date: 2020/9/28 17:51
 * Description: 多图的列表项
 */
package com.leon.module_recyvleview.customviews;

import android.content.Context;
import android.widget.LinearLayout;

import com.leon.module_recyvleview.Base.BaseCustomView;

public class MutilImgItemView extends LinearLayout implements BaseCustomView<MutilImgItemViewModel> {
    
    public MutilImgItemView(Context context) {
        super(context);
    }

    @Override
    public void loadData(MutilImgItemViewModel data) {

    }
}