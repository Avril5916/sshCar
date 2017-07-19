package com.avril.web.interceptor;
/**
 * 登录日志拦截器
 */
import java.sql.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avril.domain.Loginlogs;
import com.avril.domain.Users;
import com.avril.service.LoginlogService;
import com.avril.service.UserService;
import com.avril.service.impl.LoginlogServiceImpl;
import com.avril.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@Component

public class LoginInter extends MethodFilterInterceptor {

	@Autowired
	private LoginlogService us = new LoginlogServiceImpl();
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		String str = arg0.invoke();
		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		if(ip.equals("0:0:0:0:0:0:0:1")){
			ip = "127.0.0.1";
		}
		
		Loginlogs log = new Loginlogs();
		log.setLoginip(ip);
		log.setLoginname(user.getUsername());
		log.setLogintime(new Date(new java.util.Date().getTime()));
		this.us.addLoginlog(log);
		return str;
	}

}
