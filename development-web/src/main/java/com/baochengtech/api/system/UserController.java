package com.baochengtech.api.system;

import com.baochengtech.common.BaseController;
import com.baochengtech.common.RequestParameter;
import com.baochengtech.common.Result;
import com.baochengtech.model.User;
import com.baochengtech.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 用户
 * Created by ming.li on 2017/3/14.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    /**
     * 列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result list(){
        RequestParameter  requestParameter = getRequestParameter(User.class);
        PageInfo<User> pageInfo = userService.listByPage(requestParameter.getMapReqParam(),requestParameter.getPageNum(),requestParameter.getPageSize(),true);
        return  success(pageInfo);
    }

    /**
     * 查询
     * @param id
     * @return
     */
     @RequestMapping(value = "/{id}",method = RequestMethod.GET)
     public Result list(@PathVariable("id") Integer id){
         User user = userService.selectByPrimaryKey(id);
         return success(user);
     }

    /**
     * 新增
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(){
        RequestParameter  requestParameter = getRequestParameter(User.class);
        User user = (User) requestParameter.getObjReqParam();
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        user.setState(true);
        user= userService.insertSelective(user);
        return success(user);
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public Result delete(){
        RequestParameter  requestParameter = getRequestParameter(User.class);
        Integer id = requestParameter.getIntReqParam();
        User user = new User();
        user.setId(id);
        user.setUpdateDate(new Date());
        user.setState(false);
        Integer count = userService.updateByPrimaryKeySelective(user);
        return success(count);
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Result update(RequestParameter param){
        RequestParameter  requestParameter = getRequestParameter(User.class);
        User user = (User) requestParameter.getObjReqParam();
        user.setUpdateDate(new Date());
        Integer count = userService.updateByPrimaryKeySelective(user);
        return success(count);
    }
}
