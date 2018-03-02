package com.du.lin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.du.lin.bean.Menu;
import com.du.lin.bean.TreeNode;
import com.du.lin.dao.MenuMapper;
import com.du.lin.service.MenuService;
import com.du.lin.utils.Userinfo;
import com.google.gson.Gson;
@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
	private MenuMapper mapper;
	@Autowired
    private Gson gson;
    
	@Override
	public List<Menu> getUserMenu() {
		List<Menu> list = mapper.selectMenuByRoleid(Userinfo.getRoleid());
		return list;
	}

	@Override
	public String menuTreeData() {
		TreeNode node = new TreeNode();
		node.setId(1);
		node.setText("角色");
		node.setState("closed");
		List<TreeNode> childNode = new ArrayList<TreeNode>();
		List<Menu> menuList = mapper.selectAll();
		for (int i = 0; i < menuList.size(); i++) {
			TreeNode child = new TreeNode();
			child.setId(11+i);
			child.setText(menuList.get(i).getName());
			child.setState(null);
			childNode.add(child);
		}
		node.setChildren(childNode);
		List<TreeNode> result = new ArrayList<TreeNode>();
		result.add(node);
		return gson.toJson(result);
	}

}
