package com.avril.service.impl;
import java.util.List;

/**
 * 角色服务层
 */
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 角色服务层
 */
import org.springframework.stereotype.Service;

import com.avril.domain.Menus;
import com.avril.domain.Roles;
import com.avril.persist.RoleDao;
import com.avril.persist.impl.RoleDaoImpl;
import com.avril.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao rd ;

	@Override
	public List<Roles> findRolesAll() {
		
		return this.rd.findAll();
	}

	@Override
	public List<Roles> findRoleByName(String rolename) {
		
		return this.rd.findRoleByName(rolename);
	}

	@Override
	public List<Menus> findMenus() {
		
		return this.rd.findMenus();
	}

	@Override
	public void addRole(Roles role) {

		this.rd.insert(role);
	}

	@Override
	public void delRole(Roles role) {

		this.rd.delete(role);
	}

	@Override
	public void updateRole(Roles role) {
		this.rd.update(role);
		
	}
	
	
}
