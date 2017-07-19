package com.avril.persist;

import com.avril.domain.Users;
import com.avril.util.BaseDao;

public interface UserDao extends BaseDao<Users,String>{

	public Users findUser(Users user);

	public void deleteById(String username);
	
	public Users getById(String pk);

	
	public void update(Users t);

	public Users getByIdentity(String identity);
	
	
}
