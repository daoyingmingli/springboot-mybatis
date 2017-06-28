package com.baochengtech.mapper;

import com.baochengtech.commons.BaseMapper;
import com.baochengtech.model.UserRoleKey;
import org.springframework.stereotype.Repository;

/**
 * todo 仅有删除和新增的方法
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRoleKey,Integer> {

}