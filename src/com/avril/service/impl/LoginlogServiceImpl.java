package com.avril.service.impl;
/**
 * 登录记录服务层
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avril.domain.Cars;
import com.avril.domain.Loginlogs;
import com.avril.persist.LoginlogDao;
import com.avril.persist.impl.LoginlogDaoImpl;
import com.avril.service.LoginlogService;
import com.avril.util.Page;

@Service
public class LoginlogServiceImpl implements LoginlogService {

	@Autowired
	private LoginlogDao ld;
	@Override
	public void addLoginlog(Loginlogs log) {

		this.ld.addLoginlog(log);
	}
	@Override
	public Page findLoginlogs(Page page) {
		StringBuffer where = new StringBuffer("where 1=1 ");
		Loginlogs log = (Loginlogs) page.getList().get(0);//拿出log
		if(log.getLoginip()!=null && log.getLoginip().length()>0){//下面这一坨都是拼hql的where语句的
			where.append("and loginip = ").append(log.getLoginip()).append(" ");
		}
		if(log.getLoginlogid()!=null && log.getLoginlogid()>0){
			where.append("and loginlogid like '%").append(log.getLoginlogid()).append("%' ");
		}
		if(log.getLogintime()!=null ){
			where.append("and logintime like '%").append(log.getLogintime()).append("%' ");
		}
		if(log.getLoginname()!=null && log.getLoginname().length()>0){
			where.append("and loginname like '%").append(log.getLoginname()).append("%' ");
		}

		return this.ld.pageHQL(null, "Loginlogs", where.toString(), page.getCurrentPage());
	}
	@Override
	public void delLog(Loginlogs log) {

		this.ld.delete(log);
	}

	
}
