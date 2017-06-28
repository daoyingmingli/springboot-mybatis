/**
 * 后台服务路径地址配置
 * Created by liming on 17-3-11.
 */

var ReqUrlPath = function () {

    return {
        // -- 用户模块 --
        UserList:reqParam("/user","GET"),
        UserAdd:reqParam("/user","POST"),
        UserUpdate:reqParam("/user","PUT"),
        UserDelete:reqParam("/user","Delete"),

        // -- 角色模块 --
        RoleList:reqParam("/role","GET"),
        RoleAdd:reqParam("/role","POST"),
        RoleUpdate:reqParam("/role","PUT"),
        RoleDelete:reqParam("/role","Delete"),

        // -- 资源模块 --
        ResourceList:reqParam("/resource","GET"),
        ResourceAdd:reqParam("/resource","POST"),
        ResourceUpdate:reqParam("/resource","PUT"),
        ResourceDelete:reqParam("/resource","Delete"),

        // -- 权限模块 --
        ActionsItemList:reqParam("/actionsItem","GET"),
        ActionsItemAdd:reqParam("/actionsItem","POST"),
        ActionsItemUpdate:reqParam("/actionsItem","PUT"),
        ActionsItemDelete:reqParam("/actionsItem","Delete"),

    };

    /**
     * 请求url和方式生成函数
     * @param url
     * @param methodType
     * @returns {{url: *, type: *}}
     */
    function reqParam (url,methodType) {
        this._url = "";
        this._methodType = "get";
        var regEx = /\s+/g;
        url = url.replace(regEx,'');
        methodType = methodType.replace(regEx,'');
        if (url != undefined && url != ""){
            this._url = url;
        }
        if (methodType != undefined && methodType != ""){
            this._methodType = methodType;
        };
        return {
            url:_url,
            type:_methodType,
        }
    };
}();