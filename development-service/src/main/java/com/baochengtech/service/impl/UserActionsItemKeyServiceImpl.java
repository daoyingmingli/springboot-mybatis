package com.baochengtech.service.impl;

import com.baochengtech.commons.AbstractService;
import com.baochengtech.mapper.UserActionsItemMapper;
import com.baochengtech.model.UserActionsItemKey;
import com.baochengtech.service.UserActionsItemKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liming on 17-3-5.
 */
@Service("userActionsItemKeyService")
public class UserActionsItemKeyServiceImpl extends AbstractService<UserActionsItemKey,Integer> implements UserActionsItemKeyService{

    @Autowired
    private UserActionsItemMapper userActionsItemMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(userActionsItemMapper);
    }
}
