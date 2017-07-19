package com.avril.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avril.domain.Checktable;
import com.avril.domain.Renttable;
import com.avril.domain.Users;
import com.avril.persist.CheckTableDao;
import com.avril.persist.RenttableDao;
import com.avril.service.CheckTableService;
import com.avril.util.BaseDaoImpl;
import com.avril.util.Page;
@Service
public class CheckTableServiceImpl implements CheckTableService {

	@Autowired
	private CheckTableDao cd;
	@Autowired
	private RenttableDao rd;
	@Override
	public void save(Checktable checktable) {
		this.cd.insert(checktable);//生成检查单
		Renttable r = checktable.getRenttable();
		r.setRentflag("已归还");
		this.rd.updateflag(r);//把出租单状态设置为已归还
	}
	@Override
	public Page findChecktable(Page page) {
		StringBuffer where = new StringBuffer("where 1=1 ");
		Checktable u = (Checktable) page.getList().get(0);
		if(u.getCheckdate()!=null ){//下面这一坨都是拼hql的where语句的
			where.append("and checkdate like '%").append(u.getCheckdate()).append("%' ");
		}
		if(u.getCheckid()!=null && u.getCheckid()>0){
			where.append("and checkid like '%").append(u.getCheckid()).append("%' ");
		}
		if(u.getField()!=null && u.getField().length()>0){
			where.append("and field like '%").append(u.getField()).append("%' ");
		}
		if(u.getProblem()!=null && u.getProblem().length()>0){
			where.append("and Problem like '%").append(u.getProblem()).append("%' ");
		}
		return this.cd.pageHQL(null, "Checktable", where.toString(), page.getCurrentPage());
	}
	@Override
	public void delChecktable(Long tableid) {

		this.cd.deleteById(tableid);
	}
	
	

	
}
