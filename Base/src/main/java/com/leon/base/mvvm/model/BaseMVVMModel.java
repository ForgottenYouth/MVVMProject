/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: BaseMVVMModel
 * Author: shiwenliang
 * Date: 2020/10/12 13:47
 * Description: 视图viewmodel的basemodel
 */
package com.leon.base.mvvm.model;

import com.leon.base.exception.NoRegistException;

import java.lang.ref.WeakReference;
import java.util.List;

public abstract class BaseMVVMModel<RESULT_DATA> {

    protected WeakReference<IBaseModelListener> mListener;

    protected int mPage = 0;
    private boolean mIsPaging;//是否分页
    private final int INIT_PAGE_NUMBER;//默认的分页起始页码

    private boolean mIsLoading;//是否正在加载数据，避免重复请求

    public BaseMVVMModel(boolean isPaging, int... pageNumber) {
        this.mIsPaging = isPaging;
        if (isPaging && pageNumber != null && pageNumber.length > 0) {
            //需要分页
            INIT_PAGE_NUMBER = pageNumber[0];
        } else {
            //不需要分页
            INIT_PAGE_NUMBER = -1;
        }
    }


    public void registListener(IBaseModelListener listener) {
        if (listener != null) {
            mListener = new WeakReference<>(listener);
        }
    }

    public void refresh() {
        if (!mIsLoading) {
            if (mIsPaging) {
                mPage = INIT_PAGE_NUMBER;
            }
            mIsLoading = true;
            load();
        }
    }

    public void loadMore() {
        if (!mIsLoading) {
            mIsLoading = true;
            load();
        }
    }

    public abstract void load();

    /*
     * TODO 加载成功
     */
    public void notifyResponseData(RESULT_DATA resultData) {
        if (mListener == null) {
            return;
        }
        IBaseModelListener listener = mListener.get();
        if (listener != null) {
            if (mIsPaging) {
                listener.onLoadSuccess(resultData, new PagingResult(mPage == INIT_PAGE_NUMBER,
                        resultData == null ? true : ((List) resultData).isEmpty(),
                        ((List) resultData).size() > 0));
            } else {
                listener.onLoadSuccess(resultData);
            }

            if (mIsPaging) {
                if (resultData != null && ((List) resultData).size() > 0) {
                    mPage++;
                }
            }
        }
        mIsLoading = false;
    }

    /*
     * TODO 加载失败
     */
    public void loadFail(String errorMessage) {
        if (mListener == null) {
            return;
        }
        IBaseModelListener listener = mListener.get();
        if (listener != null) {
            if (mIsPaging) {
                listener.onLoadFailure(errorMessage, new PagingResult(mPage == INIT_PAGE_NUMBER,
                        true, false));
            } else {
                listener.onLoadFailure(errorMessage);
            }

        }
        mIsLoading = false;
    }

}