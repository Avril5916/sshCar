package com.avril.service;

import com.avril.domain.Customers;
import com.avril.domain.Users;
import com.avril.util.Page;

public interface CustomerService {
	

	void addCustomer(Customers customer);

	Page findCustomer(Page page);
	public Page findUser(Customers customer);

	void delCustomer(Integer identity);

	Customers preUpdateUser(Integer identity);

	void updateCustomer(Customers customer);

	Customers findById(Integer identity);

}
