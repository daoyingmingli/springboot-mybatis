package com.baochengtech.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baochengtech.errorcode.ErrorCodeObject;
import com.baochengtech.exception.ControllerException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liming on 17-3-4.
 */

public abstract class BaseController{
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    //获取请求类型是 RequestParameter 的方法
    protected RequestParameter getRequestParameter(Class<?> transClass){
        String s = request.getParameter("requestParameter");
        try {
            if (StringUtils.isNotBlank(s)){
                RequestParameter parameter = JSON.parseObject(s,RequestParameter.class);

                JSONObject obj = JSONObject.parseObject(s);
                if(!ObjectUtils.isEmpty(obj)){
                    // 解析 objReqParam
                    JSONObject o1 = obj.getJSONObject("objReqParam");
                    if (!ObjectUtils.isEmpty(o1) && transClass != null){
                        Object outObj = JSON.parseObject(o1.toJSONString(),transClass);
                        if (!ObjectUtils.isEmpty(outObj)){
                            parameter.setObjReqParam(outObj);
                        }
                    }

                    // 解析 mapReqParam
                    //   JSONObject.parseObject(s).getJSONObject("mapReqParam")--
                    //   .getJSONArray("elements").getJSONObject(0).get("key")
                    JSONObject o2 = obj.getJSONObject("mapReqParam");
                    if (o2 != null){
                        JSONArray arr1 = o2.getJSONArray("elements");
                        Map mapReqParam = new HashMap();
                        if (arr1 != null && arr1.size() > 0){
                            for (int i = 0 ; i < arr1.size(); i++){
                                JSONObject j = arr1.getJSONObject(i);
                                if (StringUtils.isNotBlank(j.getString("key"))
                                        && !ObjectUtils.isEmpty(j.get("value"))){
                                    mapReqParam.put(j.getString("key"),j.get("value"));
                                }
                            }
                        }
                        if ( !ObjectUtils.isEmpty(mapReqParam)){
                            parameter.setMapReqParam(mapReqParam);
                        }
                    }
                }

                return parameter;
            }
        }catch (Exception e){
            throw new ControllerException(new ErrorCodeObject(100,"请求参数转换异常"));
        }
        return null;
    }

    /**
     * 返回成功数据
     * @param obj
     * @return
     */
    public static Result success(Object obj){
        Result result = new Result();
        result.setCode(ResponseCodes.SECCESS.getCode());
        result.setMsg(ResponseCodes.SECCESS.getDesc());
        result.setData(obj);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    /**
     * 返回失败信息
     * @param code
     * @param msg
     * @return
     */
    public static Result fail(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 返回失败信息
     * @param errorCodeObject
     * @return
     */
    public static Result fail(ErrorCodeObject errorCodeObject){
        Result result = new Result();
        result.setCode(errorCodeObject.getCode());
        result.setMsg(errorCodeObject.getDesc());
        result.setData(null);
        return result;
    }


}
