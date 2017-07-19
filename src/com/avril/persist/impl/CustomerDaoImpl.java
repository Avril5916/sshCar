package com.avril.persist.impl;
/**
 * 客户Dao
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.avril.domain.Customers;
import com.avril.persist.CustomerDao;
import com.avril.util.BaseDaoImpl;
import com.avril.util.Page;
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customers, String>implements CustomerDao {

	public CustomerDaoImpl() {
		this.entityClass = Customers.class;
	}
	@Autowired
	private HibernateTemplate template;
	/*@Override
	public Customers getById(String pk) {
		//System.out.println("dao"+pk);
		Customers c = this.template.get(Customers.class, pk);
		//System.out.println("dao"+c);
		return c;
	}*/

	@Override
	public void insert(Customers t) {
		this.template.save(t);

	}

	@Override
	public void update(Customers t) {
		this.template.update(t);

	}

	@Override
	public void delete(Customers t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer pk) {
		Customers c = new Customers();
		c.setIdentity(pk);
		this.template.delete(c);

	}

	//分页查询
		@Override
		public Page pageHQL(String projection, String ClassName, String where, int pagenum) {
			// 调用的是BaseDaoImpl的分页，我从网上扒下来的，会用即可，源码参考BaseDaoImpl和Page 
			return super.pageHQL(projection, ClassName, where, pagenum);
		}

		@Override
		public Customers getById(Integer pk) {
			//System.out.println("dao"+pk);
			Customers c = this.template.get(Customers.class, pk);
			//System.out.println("dao"+c);
			return c;
		}

	

		

		

	

	

}
