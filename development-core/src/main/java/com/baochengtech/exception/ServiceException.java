package com.baochengtech.exception;

import com.baochengtech.errorcode.ErrorCodeObject;

/**
 * Service层自定义异常
 * Created by liming on 17-3-3.
 */
public class ServiceException extends BaseException{

    public ServiceException(ErrorCodeObject errorCodeObject) {
        super(errorCodeObject);
    }
}
