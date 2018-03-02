package com.du.lin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.du.lin.bean.Role;
import com.du.lin.bean.ShiroUser;
import com.du.lin.bean.User;
import com.du.lin.dao.DeptMapper;
import com.du.lin.dao.RoleMapper;
@Component
public class ShiroKit {
	
	public boolean hasRole(String role){
		return SecurityUtils.getSubject().hasRole(role);
	}

}
