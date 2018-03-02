package com.du.lin.dao;

import com.du.lin.bean.Role;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
	

	
	List<Role> selectAll();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    Role selectByRoleTip(String tips);
    
    Role  selectByRoles(String roles);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}