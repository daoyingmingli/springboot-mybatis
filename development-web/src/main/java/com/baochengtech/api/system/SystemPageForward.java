package com.baochengtech.api.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统模块的页面跳转
 * Created by liming on 17-3-14.
 */
@Controller
public class SystemPageForward {

    // -- 列表页面跳转 --
    @RequestMapping("/system/toUser")
    public String toUser(){
        return "system/user";
    }

    @RequestMapping("/system/toRole")
    public String toRole(){
        return "system/role";
    }

    @RequestMapping("/system/toResource")
    public String toResource(){
        return "system/resource";
    }

    @RequestMapping("/system/toActionsItem")
    public String toActionsItem(){
        return "system/actionsItem";
    }

    // -- 新增 --
    @RequestMapping("/system/toUserAdd")
    public String toUserAdd(){
        return "system/userAdd";
    }

    @RequestMapping("/system/toRoleAdd")
    public String toRoleAdd(){
        return "system/roleAdd";
    }

    @RequestMapping("/system/toResourceAdd")
    public String toResourceAdd(){
        return "system/resourceAdd";
    }

    @RequestMapping("/system/toActionsItemAdd")
    public String toActionsItemAdd(){
        return "system/actionsItemAdd";
    }

    // -- 编辑 --
    @RequestMapping("/system/toUserEdit")
    public String toUserEdit(){
        return "system/userAdd";
    }

    @RequestMapping("/system/toRoleEdit")
    public String toRoleEdit(){
        return "system/roleEdit";
    }

    @RequestMapping("/system/toResourceEdit")
    public String toResourceEdit(){
        return "system/resourceEdit";
    }

    @RequestMapping("/system/toActionsItemEdit")
    public String toActionsItemEdit(){
        return "system/actionsItemEdit";
    }

}
