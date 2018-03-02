package com.du.lin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.du.lin.bean.Menu;
import org.springframework.stereotype.Repository;

@Repository

public interface MenuMapper {
	
	List<Menu> selectMenuByRoleid(@Param("roleid") Integer roleid);
	
	List<Menu> selectAll();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);
    
    Menu selectByName(String name);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}