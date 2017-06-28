package com.baochengtech.service.impl;

import com.baochengtech.commons.AbstractService;
import com.baochengtech.mapper.UserRoleMapper;
import com.baochengtech.model.UserRoleKey;
import com.baochengtech.service.UserRoleKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liming on 17-3-5.
 */
@Service("userRoleKeyService")
public class UserRoleKeyServiceImpl extends AbstractService<UserRoleKey,Integer> implements UserRoleKeyService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(userRoleMapper);
    }
}
