/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: NoRegistException
 * Author: shiwenliang
 * Date: 2020/10/12 17:00
 * Description: 未注册的异常
 */
package com.leon.base.exception;

public class NoRegistException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoRegistException()
    {
        super();
    }

    public NoRegistException(String des){
        super(des);
    }
}