package com.du.lin.dao;

import com.du.lin.bean.Dept;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    Dept selectByName(String name);
    
    List<Dept> getAllDept();
    
    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}