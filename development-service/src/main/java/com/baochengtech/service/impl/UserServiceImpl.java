package com.baochengtech.service.impl;

import com.baochengtech.commons.AbstractService;
import com.baochengtech.mapper.UserMapper;
import com.baochengtech.model.User;
import com.baochengtech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liming on 17-3-5.
 */
@Service("userService")
public class UserServiceImpl extends AbstractService<User,Integer> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(userMapper);
    }
}
