package com.avril.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avril.domain.Users;
import com.avril.persist.UserDao;
import com.avril.service.UserService;
import com.avril.util.Page;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired //UserDao通过bytype注入进来
	private UserDao ud;
	//4.调用dao的findUser方法（这个方法时继承自BaseDao里的）
	@Override
	public Page findUser(Page page) {
		StringBuffer where = new StringBuffer("where 1=1 ");
		Users u = (Users) page.getList().get(0);//拿出user
		if(u.getUsername()!=null && u.getUsername().length()>0){//下面这一坨都是拼hql的where语句的
			where.append("and username like '%").append(u.getUsername()).append("%' ");
		}
		if(u.getIdentity()!=null && u.getIdentity().length()>0){
			where.append("and identity like '%").append(u.getIdentity()).append("%' ");
		}
		if(u.getPhone()!=null && u.getPhone()>0){
			where.append("and phone like '%").append(u.getPhone()).append("%' ");
		}
		if(u.getAddress()!=null && u.getAddress().length()>0){
			where.append("and address like '%").append(u.getAddress()).append("%' ");
		}
		if(u.getSex()!=null && u.getSex().length()>0){
			where.append("and sex ='").append(u.getSex()).append("' ");
		}
		if(u.getRole()!=null){
			where.append("and roleid =").append(u.getSex()).append(" ");
		}
		if(u.getFullname()!=null && u.getFullname().length()>0){
			where.append("and fullname like '%").append(u.getFullname()).append("%' ");
		}
		//参数分别是，投影（没有select就写null），要查的表实体，where语句，当前页码
		return this.ud.pageHQL(null, "Users", where.toString(), page.getCurrentPage());
	}
	
	
	@Override//登录
	public Users login(Users user) {
		Users u = this.ud.findUser(user);
		return u;
	}
	@Override//添加用户
	public void addUser(Users user) {
		this.ud.insert(user);
		
	}


	@Override//删除用户
	public void delUser(String username) {
		this.ud.deleteById(username);
		
	}


	@Override
	public Page findUser(Users user) {
		
		return null;
	}


	@Override
	public Users preUpdateUser(String username) {
		
		return this.ud.getById(username);
	}


	@Override
	public void updateUser(Users user) {
		this.ud.update(user);
		
	}


	@Override
	public Users findById(String identity) {
		
		return this.ud.getByIdentity(identity);
	}

}
