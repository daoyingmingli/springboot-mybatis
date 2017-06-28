package com.baochengtech.api.system;

import com.baochengtech.common.BaseController;
import com.baochengtech.common.RequestParameter;
import com.baochengtech.common.Result;
import com.baochengtech.model.Resource;
import com.baochengtech.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源
 * Created by ming.li on 2017/3/14.
 */
@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController{

    @Autowired
    private ResourceService resourceService;

    /**
     * 列表
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Resource> list(RequestParameter param){
        return resourceService.listByObj((Resource) param.getObjReqParam());
    }

    /**
     * 查询
     * @param id
     * @return
     */
     @RequestMapping(value = "/{id}",method = RequestMethod.GET)
     public Result list(@PathVariable("id") Integer id){
         Resource resource = resourceService.selectByPrimaryKey(id);
         return success(resource);
     }

    /**
     * 新增
     * @param resource
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestAttribute("resource") Resource resource){
        resource = resourceService.insertSelective(resource);
        return success(resource);
    }

    /**
     * 删除
     * @param resource
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public Result delete(@RequestAttribute("resource") Resource resource){
        Integer count = resourceService.deleteByPrimaryKey(resource.getId());
        return success(count);
    }

    /**
     * 修改
     * @param resource
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestAttribute("resource") Resource resource){
        Integer count = resourceService.updateByPrimaryKeySelective(resource);
        return success(count);
    }
}
