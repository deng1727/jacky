package com.du.lin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.du.lin.bean.LoginLog;
@Repository
public interface LoginLogMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteAll();

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer id);
    
    List<LoginLog> selectAll();

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKeyWithBLOBs(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}