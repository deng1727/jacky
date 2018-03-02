package com.du.lin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.du.lin.bean.LoginLog;
import com.du.lin.bean.OperationLog;
import com.du.lin.bean.ShowLog;
import com.du.lin.constant.Constant;
import com.du.lin.dao.LoginLogMapper;
import com.du.lin.dao.OperationLogMapper;
import com.du.lin.service.LoginLogService;
import com.du.lin.service.OperationLogService;
import com.du.lin.utils.BeanUtil;
import com.du.lin.utils.JqgridUtil;

@Service
public class OperationLogServiceImpl implements OperationLogService {
	@Autowired
	private OperationLogMapper mapper;
	@Autowired
	private BeanUtil beanUtil;
	@Autowired
	private JqgridUtil jqgridUtil;

	@Override
	public List<OperationLog> getAllOperationLog() {
		return mapper.selectAll();
	}

	@Override
	public List<ShowLog> getAllShowLog() {
		return beanUtil.operationLogListToShowLogList(getAllOperationLog());
	}

	@Override
	public String deleteALLLog() {
		int result = mapper.deleteAll();
		if (result > 0) {
			return Constant.OPERATION_SUCCESS_CODE;
		} else {
			return Constant.ERROR_DELETE_LOGINLOG_FAIL;
		}
	}

	@Override
	public List<ShowLog> getShowLogList(int page, int count) {
		return beanUtil.operationLogListToShowLogList(mapper.selectList((page - 1) * count, count));
	}

	@Override
	public String getShowLogJson(int page, int count) {
		List<ShowLog> all = getAllShowLog();
		int toIndex = count * page;
		if (all.size() < toIndex) {
			toIndex = all.size();
		}
		List<ShowLog> list = all.subList(count * (page - 1), toIndex);
		return jqgridUtil.getJson(list, page + "", all.size() , count);
	}

}
