/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: PagingResult
 * Author: shiwenliang
 * Date: 2020/9/30 11:27
 * Description:
 */
package com.leon.base.mvvm.model;

public class PagingResult {

    public PagingResult(boolean isFirst, boolean isEmpty, boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        this.isEmpty = isEmpty;
        this.isFirst = isFirst;
    }

    public boolean isFirst;
    public boolean isEmpty;
    public boolean hasNextPage;
}