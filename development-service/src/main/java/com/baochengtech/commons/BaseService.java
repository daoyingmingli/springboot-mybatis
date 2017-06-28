package com.baochengtech.commons;

import com.baochengtech.annotation.DataSourceAnnotation;
import com.baochengtech.datasource.DataSourcesEnum;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by liming on 17-3-5.
 */
public interface BaseService<T,ID extends Serializable> {

    void setBaseMapper();

    @Transactional

    int deleteByPrimaryKey(ID id);

    @Transactional
    @DataSourceAnnotation(ds = DataSourcesEnum.MASTER)
    T insert(T record);

    @Transactional
    @DataSourceAnnotation(ds = DataSourcesEnum.MASTER)
    T insertSelective(T record);

    T selectByPrimaryKey(ID id);

    @Transactional
    @DataSourceAnnotation(ds = DataSourcesEnum.MASTER)
    int updateByPrimaryKeySelective(T record);

    @Transactional
    @DataSourceAnnotation(ds = DataSourcesEnum.MASTER)
    int updateByPrimaryKey(T record);

    PageInfo<T> listByPage(Map<?,?> params,Integer pageNum,Integer pageSize,Boolean count);

    List<T> listByObj(T obj);
}
