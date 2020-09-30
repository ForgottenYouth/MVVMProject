/*
 * FileName: BaseCustomView
 * Author: shiwenliang
 * Date: 2020/9/28 15:06
 * Description:
 */

package com.leon.module_recyvleview.Base;

public interface BaseCustomView<T extends BaseViewModel> {

    void loadData(T data);
}
