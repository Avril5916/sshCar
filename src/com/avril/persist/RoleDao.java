package com.avril.persist;

import java.io.Serializable;
import java.util.List;

import com.avril.domain.Menus;
import com.avril.domain.Roles;
import com.avril.util.BaseDao;

public interface RoleDao extends BaseDao<Roles, Integer>{

	public List<Roles> findAll();

	public List<Roles> findRoleByName(String rolename);

	public List<Menus> findMenus();
	
	public void insert(Roles r);
	
	public void delete(Roles r);
	
	public void update(Roles r);
}
