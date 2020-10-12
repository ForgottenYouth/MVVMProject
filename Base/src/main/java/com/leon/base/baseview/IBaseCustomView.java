/*
 * FileName: BaseCustomView
 * Author: shiwenliang
 * Date: 2020/9/28 15:06
 * Description:
 */

package com.leon.base.baseview;

public interface IBaseCustomView<T extends BaseViewModel> {

    void setData(T data);
}
