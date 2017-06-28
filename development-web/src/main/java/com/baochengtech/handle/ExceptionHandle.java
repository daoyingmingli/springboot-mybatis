package com.baochengtech.handle;

import com.baochengtech.common.BaseController;
import com.baochengtech.common.ResponseCodes;
import com.baochengtech.common.Result;
import com.baochengtech.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liming on 2017/4/5.
 */
@ControllerAdvice
public class ExceptionHandle{
    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        logger.error("error:{}",e.getMessage());
        if (e instanceof BaseException){
            BaseException baseException = (BaseException)e;

            return BaseController.fail(baseException.getErrorCodeObject());
        }
        return BaseController.fail(ResponseCodes.FAIL);
    }
}
