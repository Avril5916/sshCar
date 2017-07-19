package com.avril.persist.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.avril.domain.Renttable;
import com.avril.persist.RenttableDao;
import com.avril.util.BaseDaoImpl;
import com.avril.util.Page;

@Repository
public class RenttableDaoImpl extends BaseDaoImpl<Renttable, Long>implements RenttableDao {

	@Autowired
	private HibernateTemplate template;
	public RenttableDaoImpl() {
		this.entityClass = Renttable.class;
	}
	
	@Override
	public Renttable getById(Long pk) {
		
		return this.template.get(Renttable.class, pk);
	}

	@Override
	public void insert(Renttable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Renttable t) {
		this.template.update(t);

	}

	@Override
	public void delete(Renttable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long pk) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page pageHQL(String projection, String table, String condition, int pageIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page pageCriteria(DetachedCriteria criteria, int pageIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateflag(Renttable r) {
		String hql = "update Renttable r set r.rentflag = '已归还' where r.tableid="+r.getTableid();
		this.template.bulkUpdate(hql);
	}

}
