package com.baochengtech.api;

import com.baochengtech.common.BaseController;
import com.baochengtech.common.Constants;
import com.baochengtech.common.ResponseCodes;
import com.baochengtech.common.Result;
import com.baochengtech.exception.ControllerException;
import com.baochengtech.model.User;
import com.baochengtech.service.UserService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by ming.li on 2017/3/9.
 */
@Controller
public class LoginController extends BaseController{
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model view){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam("name")String name, @RequestParam("password") String password){
        logger.info("用户:"+ name + "于"+ new Date()+"登陆系统");
        if (StringUtils.isBlank("name")){
            throw new ControllerException(ResponseCodes.SYSTEM_USER_USERNAME_NULL);
        }


        User user = new User();
        user.setName(name);
        user.setState(Boolean.TRUE);
        List<User> users = userService.listByObj(user);
        if (users == null || users.size() == 0){
            throw new ControllerException(ResponseCodes.SYSTEM_USER_USER_NOT_EXIST);
        }else if(users.size() > 1){
            throw new ControllerException(ResponseCodes.SYSTEM_USER_USER_REPEAT);
        }
        user = users.get(0);
        String pass = user.getPassword();
        if(!StringUtils.equals(Md5Crypt.md5Crypt(password.getBytes()),user.getPassword())){
            throw new ControllerException(ResponseCodes.SYSTEM_USER_PASSWORD_WRONG);
        }else{
            request.getSession().setAttribute("user",user);
            return success(null);
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user",user);
        request.getSession().removeAttribute("user");
        return "redirect:/toLogin";
    }

    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }


}
