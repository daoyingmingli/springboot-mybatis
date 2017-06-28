package com.baochengtech.common;

import com.baochengtech.errorcode.ErrorCodeObject;

/**
 * Created by Administrator on 2017/4/4.
 */
public class ResponseCodes {
    // success
    public static ErrorCodeObject  SECCESS = new ErrorCodeObject(0,Constants.RESPONE_SUCCESS);
    // error
    public static ErrorCodeObject  FAIL = new ErrorCodeObject(-1,"未知系统错误");

    //系统模块
    public static ErrorCodeObject SYSTEM_USER_USERNAME_NULL = new ErrorCodeObject(10000,"用户名不能为空");
    public static ErrorCodeObject SYSTEM_USER_PASSWORD_NULL = new ErrorCodeObject(10001,"密码不能为空");
    public static ErrorCodeObject SYSTEM_USER_USER_NOT_EXIST = new ErrorCodeObject(10002,"用户不存在");
    public static ErrorCodeObject SYSTEM_USER_USER_REPEAT = new ErrorCodeObject(10003,"系统错误，存在同名用户");
    public static ErrorCodeObject SYSTEM_USER_PASSWORD_WRONG = new ErrorCodeObject(10003,"密码不正确");

}
