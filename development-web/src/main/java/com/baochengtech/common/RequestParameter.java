package com.baochengtech.common;

import java.util.List;
import java.util.Map;

/**
 * 请求参数类
 * Created by liming on 17-3-14.
 */
public class RequestParameter {

   private Map<?,?> mapReqParam;

   private Object objReqParam;

   private List<?> listReqParam;

   private Integer intReqParam;

   private Double doubleReqParam;

    // 分页：页码
    private Integer pageNum;
    //分页：每页大小
    private Integer pageSize;
    //分页：是否总计
    private Boolean pageCount;

    // ... todo 待完善


    public Map<?,?> getMapReqParam() {
        return mapReqParam;
    }

    public void setMapReqParam(Map<?, ?> mapReqParam) {
        this.mapReqParam = mapReqParam;
    }

    public Object getObjReqParam() {
        return objReqParam;
    }

    public void setObjReqParam(Object objReqParam) {
        this.objReqParam = objReqParam;
    }

    public List<?> getListReqParam() {
        return listReqParam;
    }

    public void setListReqParam(List<?> listReqParam) {
        this.listReqParam = listReqParam;
    }

    public Integer getIntReqParam() {
        return intReqParam;
    }

    public void setIntReqParam(Integer intReqParam) {
        this.intReqParam = intReqParam;
    }

    public Double getDoubleReqParam() {
        return doubleReqParam;
    }

    public void setDoubleReqParam(Double doubleReqParam) {
        this.doubleReqParam = doubleReqParam;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getPageCount() {
        return pageCount;
    }

    public void setPageCount(Boolean pageCount) {
        this.pageCount = pageCount;
    }
}
