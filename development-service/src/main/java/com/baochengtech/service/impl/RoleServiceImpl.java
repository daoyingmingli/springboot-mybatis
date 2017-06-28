package com.baochengtech.service.impl;

import com.baochengtech.commons.AbstractService;
import com.baochengtech.mapper.RoleMapper;
import com.baochengtech.model.Role;
import com.baochengtech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liming on 17-3-5.
 */
@Service("roleService")
public class RoleServiceImpl extends AbstractService<Role,Integer> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(roleMapper);
    }
}
