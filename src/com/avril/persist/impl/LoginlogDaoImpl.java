package com.avril.persist.impl;
import org.hibernate.criterion.DetachedCriteria;
/**
 * 登录日志Dao
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.avril.domain.Loginlogs;
import com.avril.persist.LoginlogDao;
import com.avril.util.BaseDaoImpl;
import com.avril.util.Page;

@Repository
public class LoginlogDaoImpl extends BaseDaoImpl<Loginlogs, Long> implements LoginlogDao{

	public LoginlogDaoImpl() {
		this.entityClass = Loginlogs.class;
	}
	@Autowired
	private HibernateTemplate template;
	@Override
	public void addLoginlog(Loginlogs log) {//添加记录
		
		this.template.save(log);
	}
	
	
	@Override
	public Loginlogs getById(Long pk) {
		// TODO Auto-generated method stub
		return super.getById(pk);
	}
	@Override
	public void insert(Loginlogs t) {
		// TODO Auto-generated method stub
		super.insert(t);
	}
	@Override
	public void update(Loginlogs t) {
		// TODO Auto-generated method stub
		super.update(t);
	}
	@Override
	public void delete(Loginlogs t) {
		
		super.delete(t);
	}

	@Override
	public Page pageHQL(String projection, String ClassName, String where, int pagenum) {
		return super.pageHQL(projection, ClassName, where, pagenum);
	}
	@Override
	public Page pageCriteria(DetachedCriteria criteria, int pageIndex) {
		// TODO Auto-generated method stub
		return super.pageCriteria(criteria, pageIndex);
	}

	
	
}
