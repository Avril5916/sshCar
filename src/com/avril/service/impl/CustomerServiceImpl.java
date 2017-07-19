package com.avril.service.impl;
/**
 * 客户服务
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avril.domain.Customers;
import com.avril.domain.Users;
import com.avril.persist.CustomerDao;

import com.avril.service.CustomerService;
import com.avril.util.Page;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cd ;
	

	@Override
	public void addCustomer(Customers customer) {
		this.cd.insert(customer);
	}


	@Override
	public Page findCustomer(Page page) {
    StringBuffer where = new StringBuffer("where 1=1 ");
    Customers  c = (Customers) page.getList().get(0);//拿出customer
    if(c.getIdentity()!=null && c.getIdentity()>0){
		where.append("and identity like '%").append(c.getIdentity()).append("%' ");
	}
    if(c.getCustname()!=null && c.getCustname().length()>0){
		where.append("and custname like '%").append(c.getCustname()).append("%' ");	
    }
    if(c.getSex()!=null && c.getSex().length()>0){
		where.append("and sex ='").append(c.getSex()).append("' ");
	}
    if(c.getAddress()!=null && c.getAddress().length()>0){
		where.append("and address like '%").append(c.getAddress()).append("%' ");
	}
    if(c.getPhone()!=null && c.getPhone()>0){
		where.append("and phone like '%").append(c.getPhone()).append("%' ");
	}
    if(c.getCareer()!=null && c.getCareer().length()>0){
		where.append("and career like '%").append(c.getCareer()).append("%' ");
	}
    
  //参数分别是，投影（没有select就写null），要查的表实体，where语句，当前页码
  		return this.cd.pageHQL(null, "Customers", where.toString(), page.getCurrentPage());
  	
   
	}


	@Override
	public void delCustomer(Integer identity) {
		this.cd.deleteById(identity);
		
	}


	@Override
	public Customers preUpdateUser(Integer identity) {
		System.out.println("ser");
		return this.cd.getById(identity);
		
	}


	@Override
	public void updateCustomer(Customers customer) {
		this.cd.update(customer);
		
	}


	@Override
	public Page findUser(Customers customer) {
		
		return null;
	}


	@Override
	public Customers findById(Integer identity) {
		
		return this.cd.getById(identity);
	}


	
		
	


	
}
