
/**
 * 定义请求方法的参数
 * Created by ming.li on 2017/3/16.
 */

var RequestParameter = function(mapReqParam,objReqParam,listReqParam,
                     intReqParam, doubleReqParam,pageNum,pageSize)
{
    //map类型:默认{}
    this.mapReqParam = {};
    // 对象类型参数:默认 {}
    this.objReqParam = {};
    // 集合类型参数: 默认[]
    this.listReqParam = [];
    // 整形类型参数: 默认0
    this.intReqParam = 0;
    //浮点类型参数: 默认0.0
    this.doubleReqParam = 0.0;
    //查询页码: 默认1
    this.pageNum = 1;
    //每页数: 默认10
    this.pageSize = 10;
};

RequestParameter.prototype.constructor(RequestParameter);

/****************   setter   **********/
RequestParameter.prototype.setMapReqParam = function (mapReqParam) {
    if (mapReqParam != undefined && mapReqParam != null){
        this.mapReqParam = mapReqParam;
    }
};

RequestParameter.prototype.setObjReqParam = function (objReqParam) {
    if (objReqParam != undefined && objReqParam != null){
        this.objReqParam = objReqParam;
    }
};

RequestParameter.prototype.setListReqParam = function (listReqParam) {
    if (listReqParam != undefined && listReqParam != null){
        try {
            if (isArrayFn(listReqParam)){
                this.listReqParam = listReqParam;
            }else{
                throw new Error("必须是数组类型");
            }
        }catch (e){
            console.log(e);
        }
    }
};

RequestParameter.prototype.setIntReqParam = function (intReqParam) {
    if (intReqParam != undefined && intReqParam != null){
        try {
            if (Math.floor(intReqParam) === intReqParam){
                this.intReqParam = intReqParam;
            }else{
                throw new Error("必须是数字");
            }
        }catch (e){
            console.log(e);
        }
    }
};

RequestParameter.prototype.setDoubleReqParam = function (doubleReqParam) {
    if (doubleReqParam != undefined && doubleReqParam != null){
        try {
            if (!isNaN(doubleReqParam)){
                this.doubleReqParam = doubleReqParam;
            }else{
                throw new Error("必须是数字");
            }
        }catch (e){
            console.log(e);
        }
    }
};

RequestParameter.prototype.setPageNum = function (pageNum) {
    if (pageNum != undefined && pageNum != null){
        try {
            if (Math.floor(pageNum) === pageNum){
                this.pageNum = pageNum;
            }else{
                throw new Error("必须是数字");
            }
        }catch (e){
            console.log(e);
        }
    }
};

RequestParameter.prototype.setPageSize = function (pageSize) {
    if (pageSize != undefined && pageSize != null){
        try {
            if (Math.floor(pageSize) === pageSize){
                this.pageSize = pageSize;
            }else{
                throw new Error("必须是数字");
            }
        }catch (e){
            console.log(e);
        }
    }
};

/****************   getter    **********/
RequestParameter.prototype.getMapReqParam = function (){
    return this.mapReqParam;
};

RequestParameter.prototype.getObjReqParam = function (){
    return this.objReqParam;
};

RequestParameter.prototype.getListReqParam = function (){
    return this.listReqParam;
};

RequestParameter.prototype.getIntReqParam = function (){
    return this.intReqParam;
};

RequestParameter.prototype.getDoubleReqParam = function (){
    return this.doubleReqParam;
};

RequestParameter.prototype.getPageNum = function (){
    return this.pageNum;
};

RequestParameter.prototype.getPageSize = function (){
    return this.pageSize;
};


/*
 * MAP对象，实现MAP功能
 *
 * 接口：
 * size()     获取MAP元素个数
 * isEmpty()    判断MAP是否为空
 * clear()     删除MAP所有元素
 * put(key, value)   向MAP中增加元素（key, value)
 * remove(key)    删除指定KEY的元素，成功返回True，失败返回False
 * get(key)    获取指定KEY的元素值VALUE，失败返回NULL
 * element(index)   获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
 * containsKey(key)  判断MAP中是否含有指定KEY的元素
 * containsValue(value) 判断MAP中是否含有指定VALUE的元素
 * values()    获取MAP中所有VALUE的数组（ARRAY）
 * keys()     获取MAP中所有KEY的数组（ARRAY）
 *
 * 例子：
 * var map = new Map();
 *
 * map.put("key", "value");
 * var val = map.get("key")
 * ……
     var arr=map.keys();
     for(var i=0;i<arr.length;i++){
     alert(map.get(arr[i]));}
 */

function Map() {
    this.elements = new Array();

    //获取MAP元素个数
    this.size = function() {
        return this.elements.length;
    }

    //判断MAP是否为空
    this.isEmpty = function() {
        return(this.elements.length < 1);
    }

    //删除MAP所有元素
    this.clear = function() {
        this.elements = new Array();
    }

    //向MAP中增加元素（key, value)
    this.put = function(_key, _value) {
        this.elements.push( {
            key : _key,
            value : _value
        });
    }

    //删除指定KEY的元素，成功返回True，失败返回False
    this.remove = function(_key) {
        var bln = false;
        try{
            for(i = 0; i < this.elements.length; i++) {
                if(this.elements[i].key == _key) {
                    this.elements.splice(i, 1);
                    return true;
                }
            }
        } catch(e) {
            bln = false;
        }
        return bln;
    }

    //获取指定KEY的元素值VALUE，失败返回NULL
    this.get = function(_key) {
        try{
            for(i = 0; i < this.elements.length; i++) {
                if(this.elements[i].key == _key) {
                    return this.elements[i].value;
                }
            }
        } catch(e) {
            return null;
        }
    }

    //获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
    this.element = function(_index) {
        if(_index < 0 || _index >= this.elements.length) {
            return null;
        }
        return this.elements[_index];
    }

    //判断MAP中是否含有指定KEY的元素
    this.containsKey = function(_key) {
        varbln = false;
        try{
            for(i = 0; i < this.elements.length; i++) {
                if(this.elements[i].key == _key) {
                    bln = true;
                }
            }
        } catch(e) {
            bln = false;
        }
        return bln;
    }

    //判断MAP中是否含有指定VALUE的元素
    this.containsValue = function(_value) {
        var bln = false;
        try{
            for(i = 0; i < this.elements.length; i++) {
                if(this.elements[i].value == _value) {
                    bln = true;
                }
            }
        } catch(e) {
            bln = false;
        }
        return bln;
    }

    //获取MAP中所有VALUE的数组（ARRAY）
    this.values = function() {
        var arr = new Array();
        for(i = 0; i < this.elements.length; i++) {
            arr.push(this.elements[i].value);
        }
        return arr;
    }

    //获取MAP中所有KEY的数组（ARRAY）
    this.keys = function() {
        var arr = new Array();
        for(i = 0; i < this.elements.length; i++) {
            arr.push(this.elements[i].key);
        }
        return arr;
    }
}
/**
 * 判断是否是数组
 * @param value
 * @returns {boolean}
 */
function isArrayFn(value){
    if (typeof Array.isArray === "function") {
        return Array.isArray(value);
    }else{
        return Object.prototype.toString.call(value) === "[object Array]";
    }
}