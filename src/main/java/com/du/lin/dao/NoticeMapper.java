package com.du.lin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.du.lin.bean.Notice;
@Repository
public interface NoticeMapper {
	
	List<Notice> getAllNotice();
	
	List<Notice> getTop15Notices();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}