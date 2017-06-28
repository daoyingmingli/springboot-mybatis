package com.baochengtech.commons;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by liming on 17-3-4.
 */
public interface BaseMapper<T,ID extends Serializable> {

    Integer deleteByPrimaryKey(ID id);

    Integer insert(T record);

    Integer insertSelective(T record);

    T selectByPrimaryKey(ID id);

    Integer updateByPrimaryKeySelective(T record);

    Integer updateByPrimaryKey(T record);

    List<T> listByPage(Map<?,?> params);

    List<T> listByObj(T obj);
}