package com.baochengtech.service.impl;

import com.baochengtech.commons.AbstractService;
import com.baochengtech.mapper.RoleResourceMapper;
import com.baochengtech.model.RoleResourceKey;
import com.baochengtech.service.RoleResourceKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liming on 17-3-5.
 */
@Service("roleResourceKeyService")
public class RoleResourceKeyServiceImpl extends AbstractService<RoleResourceKey,Integer> implements RoleResourceKeyService {

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(roleResourceMapper);
    }
}
