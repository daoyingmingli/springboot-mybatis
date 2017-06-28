package com.baochengtech.common;

/**
 * Created by ming.li on 2017/3/14.
 */
public class Constants {

    // redis参数配置
    public static final String REDIS_HOST = "182.92.151.45" ;
    public static final Integer REDIS_PORT = 6379 ;
    public static final Integer REDIS_TIMEOUT = 1000 ;


    // reponse 状态
    public static final String RESPONE_SUCCESS = "success";
    public static final String RESPONE_FAIL = "fail";


    // 数据 状态
    public static final Byte DATA_VALID = Byte.valueOf("1");
    public static final Byte DATA_INVALID = Byte.valueOf("0");

}
