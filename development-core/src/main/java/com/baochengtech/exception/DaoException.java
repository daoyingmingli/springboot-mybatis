package com.baochengtech.exception;

import com.baochengtech.errorcode.ErrorCodeObject;

/**
 * Dao层自定义异常
 * Created by liming on 17-3-3.
 */
public class DaoException extends BaseException{

    public DaoException(ErrorCodeObject errorCodeObject) {
        super(errorCodeObject);
    }
}
