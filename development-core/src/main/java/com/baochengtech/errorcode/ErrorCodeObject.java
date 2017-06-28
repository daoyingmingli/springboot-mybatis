package com.baochengtech.errorcode;

/**
 * Created by liming on 17-3-3.
 */
public class ErrorCodeObject {

    private Integer code = null;
    private String desc = null;

    public ErrorCodeObject(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
