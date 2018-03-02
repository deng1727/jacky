package com.du.lin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.du.lin.bean.OperationLog;
@Repository
public interface OperationLogMapper {
    int deleteByPrimaryKey(Integer id);
    
    List<OperationLog> selectAll();
    
    List<OperationLog> selectList(@Param("index") Integer index ,@Param("count") int count);
    
    int deleteAll();

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKey(OperationLog record);
}