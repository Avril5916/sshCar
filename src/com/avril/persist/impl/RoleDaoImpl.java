package com.avril.persist.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
/**
 * 角色Dao
 */
import org.springframework.stereotype.Repository;

import com.avril.domain.Menus;
import com.avril.domain.Roles;
import com.avril.persist.RoleDao;
import com.avril.util.BaseDaoImpl;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Roles, Integer> implements RoleDao {

	public RoleDaoImpl() {
		this.entityClass = Roles.class;
	}
	@Autowired
	private HibernateTemplate template;
	
	@Override
	public List<Roles> findAll() {//查所有角色
		String hql = "from Roles ";
		return (List<Roles>) this.template.find(hql);
	}
	
	
	@Override
	public Roles getById(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Roles r) {
		this.template.save(r);

	}

	//编辑角色
	@Override
	public void update(Roles r) {
		this.template.saveOrUpdate(r);

	}

	@Override
	public void delete(Roles r) {
		this.template.delete(r);
	}

	@Override
	public void deleteById(Integer pk) {
		// TODO Auto-generated method stub

	}


	@Override//根据名模糊查询角色
	public List<Roles> findRoleByName(String rolename) {
		StringBuffer hql = new StringBuffer("from Roles where 1=1 ");
		if(rolename!=null&&rolename.length()>0){
			hql.append("and rolename like '%").append(rolename).append("%' ");
		}
		
		return (List<Roles>) this.template.find(hql.toString());
	}


	@Override
	public List<Menus> findMenus() {
		
		return (List<Menus>) this.template.find("from Menus");
	}



}
