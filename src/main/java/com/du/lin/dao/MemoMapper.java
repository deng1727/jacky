package com.du.lin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.du.lin.bean.Memo;
@Repository
public interface MemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Memo record);

    int insertSelective(Memo record);

    Memo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Memo record);

    int updateByPrimaryKey(Memo record);
    
    List<Memo> getAllByUserId(@Param("userid") Integer userid);
    
}