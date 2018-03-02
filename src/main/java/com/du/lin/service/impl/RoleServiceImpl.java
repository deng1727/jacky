package com.du.lin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.du.lin.bean.Dept;
import com.du.lin.bean.Menu;
import com.du.lin.bean.Role;
import com.du.lin.bean.RoleMenuRelation;
import com.du.lin.bean.ShowRole;
import com.du.lin.bean.User;
import com.du.lin.constant.Constant;
import com.du.lin.dao.MenuMapper;
import com.du.lin.dao.RoleMapper;
import com.du.lin.dao.RoleMenuRelationMapper;
import com.du.lin.dao.UserMapper;
import com.du.lin.service.RoleService;
import com.du.lin.utils.BeanUtil;
import com.du.lin.utils.JqgridUtil;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper mapper;
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JqgridUtil jqgridUtil;
	@Autowired
	private RoleMenuRelationMapper rmrMapper;
	
	@Override
	public List<ShowRole> getAllShowRole() {
		
		List<Role> list = mapper.selectAll();
		List<ShowRole> result = new ArrayList<ShowRole>();
		for (Role role : list) {
			StringBuilder menus = new StringBuilder();
			ShowRole sr = new ShowRole();
			sr.setId(role.getId());
			sr.setRoles(role.getRoles());
			sr.setTips(role.getTips());
			List<Menu> menuList = menuMapper.selectMenuByRoleid(role.getId());
			if (menuList.size()>0) {
				for (Menu menu : menuList) {
					menus.append(menu.getName()).append(",");
				}
				
				sr.setMenus(menus.substring(0, menus.length()-1));	
			}else {
				sr.setMenus("无");
			}

			result.add(sr);
		}
		
		
		return result;
	}

	@Override
	public String getAllShowRoleJson(int page, int count) {

		List<ShowRole> all = getAllShowRole();
		int toIndex = count * page;
		if (all.size() < toIndex) {
			toIndex = all.size();
		}
		List<ShowRole> list = all.subList(count * (page - 1), toIndex);
		return jqgridUtil.getJson(list, page + "", all.size() , count);
	
	}

	@Override
	public String addRole(String roleName, String englisgName) {
		roleName = roleName.trim();
		englisgName = englisgName.trim();
		if ("".endsWith(roleName)) {
			return "";
		}
		if ("".endsWith(englisgName)) {
			return "";
		}
		if(!englisgName.matches("^[a-zA-Z\\d_]*$")){
			return Constant.ERROR_CODE_NOT_MATCHE;
		}
		
		Role role = new Role();
		role.setRoles(englisgName);
		role.setTips(roleName);
		if(mapper.selectByRoles(englisgName) != null){
			return Constant.ERROR_CODE_ROLES_EXIST;
		}
		if(mapper.selectByRoleTip(roleName) != null){
			return Constant.ERROR_CODE_TIPS_EXIST;
		}
		
		int result = mapper.insertSelective(role);
		if (result == 1) {
			return Constant.OPERATION_SUCCESS_CODE;			
		}
		return Constant.UNKNOWN_ERROR_CODE;
	}

	@Override
	public String setRole(int id, String tips, String roles) {
		tips = tips.trim();
		roles = roles.trim();
		if ("".endsWith(tips)) {
			return "";
		}
		if ("".endsWith(roles)) {
			return "";
		}
		if(!roles.matches("^[a-zA-Z\\d_]*$")){
			return Constant.ERROR_CODE_NOT_MATCHE;
		}
		
		Role role = new Role();
		role.setId(id);
		role.setRoles(roles);
		role.setTips(tips);
		if(mapper.selectByRoles(roles) != null){
			return Constant.ERROR_CODE_ROLES_EXIST;
		}
		if(mapper.selectByRoleTip(tips) != null){
			return Constant.ERROR_CODE_TIPS_EXIST;
		}
		
		int result = mapper.updateByPrimaryKeySelective(role);
		if (result == 1) {
			return Constant.OPERATION_SUCCESS_CODE; 
		}
		return Constant.UNKNOWN_ERROR_CODE;
	}

	@Override
	public String deleteRole(int id) {
		int result = mapper.deleteByPrimaryKey(id);
		if (result == 1) {
			rmrMapper.deleteByRoleid(id);
			userMapper.updateByRoleidSelective(id);
			return Constant.OPERATION_SUCCESS_CODE;
		}
		return Constant.UNKNOWN_ERROR_CODE;
	}

	@Override
	public String roleListForUserAdd() {
        List<Role> list = mapper.selectAll();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getId() + ":" + list.get(i).getTips() + ";");
        }
        return sb.substring(0, sb.length()-1);
    
	}

	@Override
	public String addRelation(int roleid, String menus) {
		int size = 0;
		List<String> menuList = Arrays.asList(menus.split(","));
		rmrMapper.deleteByRoleid(roleid);
		for (String string : menuList) {
			Menu menu = menuMapper.selectByName(string);
			if (menu != null) {
				RoleMenuRelation rmr = new RoleMenuRelation();
				rmr.setMenuid(menu.getId());
				rmr.setRoleid(roleid);
				rmrMapper.insert(rmr);
				size++;
			}
		}
			return Constant.OPERATION_SUCCESS_CODE;
	}

}
