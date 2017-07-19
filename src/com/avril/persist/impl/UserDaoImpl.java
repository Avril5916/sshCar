package com.avril.persist.impl;
/**
 * 用户Dao
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.avril.domain.Loginlogs;
import com.avril.domain.Users;
import com.avril.persist.UserDao;
import com.avril.util.BaseDaoImpl;
import com.avril.util.Page;

@Repository
public class UserDaoImpl extends BaseDaoImpl<Users,String> implements UserDao {

	@Autowired
	private HibernateTemplate template;

	public UserDaoImpl() {
		this.entityClass = Users.class;
	}
	
	
	
	//分页查询
	@Override
	public Page pageHQL(String projection, String ClassName, String where, int pagenum) {
		return super.pageHQL(projection, ClassName, where, pagenum);
	}




	@Override
	public Users findUser(Users user) {//非模糊查询单个
		StringBuffer hql = new StringBuffer("from Users where 1=1 ");
		if(user.getUsername()!=null && user.getUsername().length()>0){
			hql.append("and username = '").append(user.getUsername()).append("' ");
		}
		if(user.getUserpwd()!=null && user.getUserpwd().length()>0){
			hql.append("and userpwd = '").append(user.getUserpwd()).append("' ");
		}
		List<Users> ulist =  (List<Users>) this.template.find(hql.toString());
		return ulist.get(0);
	}

	@Override
	public void insert(Users t) {//添加用户
		this.template.save(t);
	}

	@Override
	public Users getById(String pk) {
		
		return this.template.get(Users.class, pk);
	}




	@Override
	public void update(Users t) {
		this.template.update(t);
	}


	@Override
	public void delete(Users t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteById(String pk) {
		Users u = new Users();
		u.setUsername(pk);
		this.template.delete(u);
		
	}



	//根据id验证
	@Override
	public Users getByIdentity(String identity) {
		StringBuffer hql = new StringBuffer("from Users where 1=1 ");
		if(identity!=null&&identity.length()>0){
			hql.append("and identity='"+identity+"' ");
		}
		List<Users> ulist = (List<Users>) this.template.find(hql.toString());
		if(!ulist.isEmpty()){
			return ulist.get(0);
		}else{
		return null;
	}
	}
	
}
