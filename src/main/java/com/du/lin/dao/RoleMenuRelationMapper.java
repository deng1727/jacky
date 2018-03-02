package com.du.lin.dao;

import org.springframework.stereotype.Repository;

import com.du.lin.bean.RoleMenuRelation;
@Repository
public interface RoleMenuRelationMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByRoleid(Integer roleid);

    int insert(RoleMenuRelation record);

    int insertSelective(RoleMenuRelation record);

    RoleMenuRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenuRelation record);

    int updateByPrimaryKey(RoleMenuRelation record);
}