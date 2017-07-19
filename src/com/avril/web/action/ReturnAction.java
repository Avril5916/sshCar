package com.avril.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.avril.domain.Checktable;
import com.avril.domain.Renttable;
import com.avril.domain.Users;
import com.avril.service.CheckTableService;
import com.avril.service.RenttableService;
import com.avril.util.Page;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class ReturnAction extends ActionSupport{

	@Autowired
	private RenttableService rs;
	@Autowired
	private CheckTableService cs;
	private Long tableid;
	private String msg;
	private Checktable checktable;
	private Renttable renttable;
	private Page page;
	private Integer currentPage;
	
	//查找订单
	@Action(value="findRenttable",results={@Result(name="showRenttable",location="/showRenttable.jsp"),@Result(name="returnCar",location="/returnCar.jsp")})
	public String findRenttable(){
		this.renttable= this.rs.findRenttableById(tableid);
		if(this.renttable!=null){
			if(this.renttable.getRentflag().equals("已归还")){
				this.msg = "该订单已完成";
				return "returnCar";
			}else{
				this.checktable = new Checktable();
				this.checktable.setCheckid(new Date().getTime());
				this.checktable.setCheckdate(new Date());
				//从session中获取登录是记录在内的user信息 去登录的用户作为检查员
				String username =((Users) ServletActionContext.getRequest().getSession().getAttribute("user")).getUsername();
				Users u = new Users();
				u.setUsername(username);
				this.checktable.setUser(u);
				return "showRenttable";
			}
		}else{
			this.msg = "没有该订单";
			return "returnCar";
		}
	}
	
	@Action(value="returnCar",results={@Result(name="ok",location="/ok.jsp")})
	public String returnCar(){
		Renttable r = new Renttable();
		r.setTableid(this.tableid);
		this.checktable.setRenttable(r);
		this.cs.save(this.checktable);
		return "ok";
	}
	
	@Action(value="findChecktable",results={@Result(name="showChecktable",location="/showChecktable.jsp")})
	public String findChecktable(){
		List<Checktable> list = new ArrayList<>();
		page = new Page();
		list.add(this.checktable);
		page.setList(list);
		page.setCurrentPage(this.currentPage);
		this.page = this.cs.findChecktable(page);
		return "showChecktable";
	}
	
	@Action(value="delChecktable",results={@Result(name="ok",location="/ok.jsp")})
	public String delChecktable(){
		this.cs.delChecktable(this.tableid);
		return "ok";
	}
	
	
	
	public Long getTableid() {
		return tableid;
	}
	public void setTableid(Long tableid) {
		this.tableid = tableid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Checktable getChecktable() {
		return checktable;
	}

	public void setChecktable(Checktable checktable) {
		this.checktable = checktable;
	}

	public Renttable getRenttable() {
		return renttable;
	}

	public void setRenttable(Renttable renttable) {
		this.renttable = renttable;
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
