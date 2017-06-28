package com.baochengtech.service.impl;

import com.baochengtech.commons.AbstractService;
import com.baochengtech.mapper.ActionsItemMapper;
import com.baochengtech.model.ActionsItem;
import com.baochengtech.service.ActionsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liming on 17-3-5.
 */
@Service("actionsItemService")
public class ActionsItemServiceImpl extends AbstractService<ActionsItem,Integer> implements ActionsItemService {

    @Autowired
    private ActionsItemMapper actionsItemMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(actionsItemMapper);
    }
}
