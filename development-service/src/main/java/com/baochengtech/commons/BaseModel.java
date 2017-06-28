package com.baochengtech.commons;

import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liming on 17-3-4.
 */

public class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    private Date queryStartTime;

    @Transient
    private Date queryEndTime;

    public Date getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(Date queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    public Date getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(Date queryEndTime) {
        this.queryEndTime = queryEndTime;
    }
}
