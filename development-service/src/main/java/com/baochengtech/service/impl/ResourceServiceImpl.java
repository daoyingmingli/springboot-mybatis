package com.baochengtech.service.impl;

import com.baochengtech.commons.AbstractService;
import com.baochengtech.mapper.ResourceMapper;
import com.baochengtech.model.Resource;
import com.baochengtech.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liming on 17-3-5.
 */
@Service("resourceService")
public class ResourceServiceImpl extends AbstractService<Resource,Integer> implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(resourceMapper);
    }
}
