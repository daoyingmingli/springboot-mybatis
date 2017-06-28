package com.baochengtech.api.system;

import com.baochengtech.common.BaseController;
import com.baochengtech.common.RequestParameter;
import com.baochengtech.common.Result;
import com.baochengtech.model.ActionsItem;
import com.baochengtech.service.ActionsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限
 * Created by ming.li on 2017/3/14.
 */
@RestController
@RequestMapping("/actionsItem")
public class ActionsItemController extends BaseController{

    @Autowired
    private ActionsItemService actionsItemService;

    /**
     * 列表
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<ActionsItem> list(RequestParameter param){
        return actionsItemService.listByObj((ActionsItem) param.getObjReqParam());
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result list(@PathVariable("id") Integer id){
        ActionsItem actionsItem = actionsItemService.selectByPrimaryKey(id);
        return success(actionsItem);
    }

    /**
     * 新增
     * @param actionsItem
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestAttribute("actionsItem") ActionsItem actionsItem){
        actionsItem = actionsItemService.insertSelective(actionsItem);
        return success(actionsItem);
    }

    /**
     * 删除
     * @param actionsItem
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public Result delete(@RequestAttribute("actionsItem") ActionsItem actionsItem){
        Integer count = actionsItemService.deleteByPrimaryKey(actionsItem.getId());
        return success(count);
    }

    /**
     * 修改
     * @param actionsItem
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestAttribute("actionsItem") ActionsItem actionsItem){
        Integer count = actionsItemService.updateByPrimaryKeySelective(actionsItem);
        return success(count);
    }
}
