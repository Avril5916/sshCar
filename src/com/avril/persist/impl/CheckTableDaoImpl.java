package com.avril.persist.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.avril.domain.Checktable;
import com.avril.persist.CheckTableDao;
import com.avril.util.BaseDaoImpl;
import com.avril.util.Page;

@Repository
public class CheckTableDaoImpl extends BaseDaoImpl<Checktable, Long>implements CheckTableDao {

	@Autowired
	private HibernateTemplate template;
	public CheckTableDaoImpl() {
		this.entityClass = Checktable.class;
	}
	@Override
	public void insert(Checktable t) {
		
		this.template.save(t);
	}
	@Override
	public Page pageHQL(String projection, String ClassName, String where, int pagenum) {
		
		return super.pageHQL(projection, ClassName, where, pagenum);
	}
	@Override
	public void deleteById(Long pk) {
		Checktable c = new Checktable();
		c.setCheckid(pk);
		this.template.delete(c);
	}
	
	

	
	
	
}
