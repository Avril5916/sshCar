package com.avril.persist;

import com.avril.domain.Customers;

import com.avril.util.BaseDao;

public interface CustomerDao extends BaseDao<Customers, String> {
	
	public void insert(Customers customer);
	
	public void deleteById(Integer identity);

	public Customers getById(Integer pk);

	public void update(Customers t);
	
	     
}
