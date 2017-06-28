package com.baochengtech.exception;

import com.baochengtech.errorcode.ErrorCodeObject;

/**
 * Controller层自定义异常
 * Created by liming on 17-3-3.
 */

public class ControllerException extends BaseException{

    public ControllerException(ErrorCodeObject errorCodeObject) {
        super(errorCodeObject);
    }
}
