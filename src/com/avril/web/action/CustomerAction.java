package com.avril.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.avril.domain.Customers;
import com.avril.service.CustomerService;


import com.avril.util.Page;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class CustomerAction extends ActionSupport{

	@Autowired
	private CustomerService cs ;
	
	private Customers customer;
	private Integer identity;
	private List<Customers> clist;
	private Page page;
	private Integer currentPage;//页码
	
	public List<Customers> getClist() {
		return clist;
	}
	public void setClist(List<Customers> clist) {
		this.clist = clist;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Customers getCustomer() {
		return  customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	
	
	public Integer getIdentity() {
		return identity;
	}
	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	@Action(value="addCustomer",results={@Result(name="ok",location="/ok.jsp")})
	public String addCustomer(){
		this.cs.addCustomer(this.customer);
		return "ok";
		
	}
	@Action(value="findCustomer",results={@Result(name="showCustomer",location="/showCustomer.jsp")})
	public String findCustomer(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		clist = new ArrayList<>();
		page = new Page();
		this.clist.add(customer);
		page.setList(clist);
		page.setCurrentPage(this.currentPage);
		this.page = this.cs.findCustomer(page);
		return "showCustomer";
		
	}
	@Action(value="delCustomer",results={@Result(name="ok",location="/ok.jsp")})
	public String delCustomer(){
		this.cs.delCustomer(identity);
		return "ok";
		
	}
	//预查询
	@Action(value="preUpdateCustomer",results={@Result(name="update",location="/updateCustomer.jsp")})
	public String preUpdateCustomer(){
		this.customer=this.cs.preUpdateUser(this.identity);
		return "update";
	}
	
	
	//更新
	@Action(value="updateCustomer",results={@Result(name="ok",location="/ok.jsp",type="redirect")})
	public String updateCustomer(){
		System.out.println(customer);
		this.cs.updateCustomer(this.customer);
		System.out.println(1);
		return "ok";
	}
}
