package com.baochengtech.api.system;

import com.baochengtech.common.BaseController;
import com.baochengtech.common.RequestParameter;
import com.baochengtech.common.Result;
import com.baochengtech.model.Role;
import com.baochengtech.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色
 * Created by ming.li on 2017/3/14.
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 列表
     *
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result list(RequestParameter param) {
        PageInfo<Role> pageInfo = roleService.listByPage(param.getMapReqParam(), param.getPageNum(), param.getPageSize(), false);
        return  success(pageInfo);
    }

    /**
     * 查询
     * @return
     */
     @RequestMapping(value = "/{id}",method = RequestMethod.GET)
     public Result selectOne(@PathVariable("id") Integer id){
         Role role = roleService.selectByPrimaryKey(id);
         return success(role);
     }

    /**
     * 新增
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(RequestParameter param){
        Role role = (Role) param.getObjReqParam();
        role = roleService.insertSelective(role);
        return success(role);
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public Result delete(RequestParameter param){
        Integer id = param.getIntReqParam();
        Integer count = roleService.deleteByPrimaryKey(id);
        return success(count);
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Result update(RequestParameter param){
        Role role = (Role) param.getObjReqParam();
        Integer count = roleService.updateByPrimaryKeySelective(role);
        return success(count);
    }
}
