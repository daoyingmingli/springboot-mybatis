package com.baochengtech.commons;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract  class AbstractService<T, ID extends Serializable> implements BaseService<T, ID> {

    private BaseMapper<T, ID> baseMapper;

    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public T insertSelective(T record) {
        baseMapper.insertSelective(record);
        return record;
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    public T insert(T record) {
        baseMapper.insert(record);
        return record;
    }

    @Override
    public PageInfo<T> listByPage(Map<?,?> params, Integer pageNum, Integer pageSize, Boolean count){
        PageHelper.startPage(pageNum,pageSize,count);
        List<T> result  = baseMapper.listByPage(params);
        return  new PageInfo<>(result);
    }

    @Override
    public List<T> listByObj(T obj){
        return baseMapper.listByObj(obj);
    }

}