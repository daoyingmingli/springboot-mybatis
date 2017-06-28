/**
 * Created by ming.li on 2017/3/16.
 */

$(function(){

    /**
     * @param reqUrlPathValue
     * @param requestParameter
     * @param isAsync
     * 仅适用于请求地址类型ReqUrlPath;参数类型为RequestParameter的情形;
     */
    jQuery.ajaxReqUtil = function(reqUrlPathValue,requestParameter,isAsync,successFn,errorFn) {
        if (reqUrlPathValue == undefined || reqUrlPathValue == null) {
            return {rep_type: "error", rep_data: "请求的ReqUrlPath值不能为空"};
        }

        var _reqUrlPath = reqUrlPathValue;
        var _requestParameter = requestParameter;

        if (_requestParameter == undefined || _requestParameter == null) {
            _requestParameter = new RequestParameter();
        } else {
            if (!_requestParameter instanceof RequestParameter) {
                return {rep_type: "error", rep_data: "请求参数requestParameter类型错误"};
            }
        }

        var url = _reqUrlPath.url;
        if (url == undefined || url == "") {
            return {rep_type: "error", rep_data: "URL不能为空"};
        }

        var type = _reqUrlPath.type;

        ajaxRequestMethod(url, type, {requestParameter: JSON.stringify(_requestParameter)}, "json", isAsync,successFn,errorFn);
    }


    /**
     * rest请求路径类型 eg: /user/{1}/
     * @param reqUrlPath
     * @param requestParameter
     * @param isAsync
     */
    function ajaxPathValiableReqUtil(url,isAsync,successFn,failFn) {
        return ajaxRequestMethod(url,"GET",null,null,isAsync,successFn,failFn);
    }

    /**
     * ajax请求通用方法
     * @param url
     * @param type
     * @param param
     * @param dataType
     * @param isAsync
     * @param successFn
     * @param failFn
     */
    function ajaxRequestMethod(url,type,param,dataType,isAsync,successFn,failFn){
        isAsync = (isAsync==null || isAsync=="" || typeof(isAsync)=="undefined")? "true" : isAsync;
        type = (type==null || type=="" || typeof(type)=="undefined")? "GET" : type;
        dataType = (dataType==null || dataType=="" || typeof(dataType)=="undefined")? "json" : dataType;
        param = (param==null || param=="" || typeof(param)=="undefined")? {"date": new Date().getTime()} : param;

        $.ajax({
            type:type,
            url: url,
            data:param,
            dataType: dataType,
            async:isAsync,
            success: function (d) {
                successFn(d);
            },
            error: function (e) {
                failFn(e);
            }
        });
    }

});