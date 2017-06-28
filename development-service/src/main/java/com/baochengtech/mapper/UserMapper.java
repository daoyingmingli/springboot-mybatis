package com.baochengtech.mapper;

import com.baochengtech.commons.BaseMapper;
import com.baochengtech.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User,Integer> {

}