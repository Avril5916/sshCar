package com.avril.service;

import com.avril.domain.Users;
import com.avril.util.Page;

public interface UserService {

	public Users login(Users user);

	public void addUser(Users user);

	public Page findUser(Users user);

	public Page findUser(Page page);

	public void delUser(String username);

	public Users preUpdateUser(String username);

	public void updateUser(Users user);

	public Users findById(String identity);
		
	
}
