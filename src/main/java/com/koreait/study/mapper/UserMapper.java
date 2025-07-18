package com.koreait.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.koreait.study.model.User;

@Mapper
public interface UserMapper {
    User findByUserId(String userId);
    void insert(User user);
}

