package com.avril.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.avril.domain.Customers;
import com.avril.service.CustomerService;
import com.avril.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class RentAction extends ActionSupport {

	 private Integer identity;
	 @Autowired
	 private UserService us;
	 @Autowired
	 private CustomerService cs;
	 
	 //ajax验证id
	 @Action(value="validateId",results={@Result(name="preRnet",location="/preRnet.jsp")})
	 public String validateId() throws IOException{
		 //调用service来查询   
		    Customers u =cs.findById(identity);  
		    //获得response  
		   
		    HttpServletResponse response=  ServletActionContext.getResponse();  
		    response.setContentType("text/html;charset=UTF-8");  
		    if(u != null){  
		        //存在  括号里是返回的诗句
		        response.getWriter().println("<font color='green'>用户存在</font>");  
		    }else{  
		        response.getWriter().println("<font color='red'>用户名不存在</font>");  
		    }  
		 return null;
	 }
	 
	 
	 
	public Integer getIdentity() {
		return identity;
	}
	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
}
