package com.avril.service;

import java.util.List;

import com.avril.domain.Menus;
import com.avril.domain.Roles;

public interface RoleService {

	public List<Roles> findRolesAll();

	public List<Roles> findRoleByName(String rolename);

	public List<Menus> findMenus();
	
	public void addRole(Roles role);

	public void delRole(Roles role);

	public void updateRole(Roles role);
}
