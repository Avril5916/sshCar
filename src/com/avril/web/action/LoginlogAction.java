package com.avril.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.avril.domain.Loginlogs;
import com.avril.service.LoginlogService;
import com.avril.util.Page;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class LoginlogAction extends ActionSupport {

	@Autowired
	private LoginlogService ls ;

	private Loginlogs log;
	private Page page;
	private Integer currentPage;
	private List<Loginlogs> llist;

	@Action(value="finLoginlog",results={@Result(name="showLoginlog",location="/showLoginlog.jsp")})
	public String finLoginlog(){
		llist = new ArrayList<>();
		page = new Page();
		this.llist.add(log);
		page.setList(llist);
		page.setCurrentPage(this.currentPage);
		this.page = this.ls.findLoginlogs(page);
		
		return "showLoginlog";
	}
	
	@Action(value="delLog",results={@Result(name="ok",location="/ok.jsp")})
	public String delLog(){
		this.ls.delLog(log);
		return "ok";
	}
	
	
	
	
	
	public Loginlogs getLog() {
		return log;
	}
	public void setLog(Loginlogs log) {
		this.log = log;
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
	
}
