package com.baochengtech.exception;

import com.baochengtech.errorcode.ErrorCodeObject;

/**
 * Created by liming on 17-3-3.
 */
public class BaseException extends RuntimeException{

    protected ErrorCodeObject errorCodeObject;

    public BaseException(ErrorCodeObject errorCodeObject) {
        this.errorCodeObject = errorCodeObject;
    }

    public ErrorCodeObject getErrorCodeObject() {
        return errorCodeObject;
    }

    public void setErrorCodeObject(ErrorCodeObject errorCodeObject) {
        this.errorCodeObject = errorCodeObject;
    }
}
