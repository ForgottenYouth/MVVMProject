/*
 * FileName: IBaseModelListener
 * Author: shiwenliang
 * Date: 2020/9/30 11:16
 * Description:
 */

package com.leon.base.mvvm.model;

public interface IBaseModelListener<DATA> {
    /*
    * TODO 加载成功
    */
    void onLoadSuccess(DATA data,PagingResult... pagingResults);
    
    /*
    * TODO 加载失败
    */
    void onLoadFailure(String message);
}
