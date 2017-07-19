package com.avril.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avril.domain.Cars;
import com.avril.domain.Users;
import com.avril.persist.CarDao;
import com.avril.persist.impl.CarDaoImpl;
import com.avril.persist.CarDao;
import com.avril.service.CarService;
import com.avril.util.BaseDaoImpl;
import com.avril.util.Page;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao cd ;

	@Override
	public void addCar(Cars car) {
		cd.insert(car);
	}

	

	@Override
	public Page findCar(Page page) {
		StringBuffer where = new StringBuffer("where 1=1 ");
		Cars u = (Cars) page.getList().get(0);//拿出car
		if(u.getCarnumber()!=null && u.getCarnumber().length()>0){//下面这一坨都是拼hql的where语句的
			where.append("and carnumber like '%").append(u.getCarnumber()).append("%' ");
		}
		if(u.getCartype()!=null && u.getCartype().length()>0){
			where.append("and cartype like '%").append(u.getCartype()).append("%' ");
		}
		if(u.getColor()!=null && u.getColor().length()>0){
			where.append("and color like '%").append(u.getColor()).append("%' ");
		}
		if(u.getPrice()!=null && u.getPrice()>0){
			where.append("and price = ").append(u.getPrice()).append(" ");
		}
		if(u.getDeposit()!=null && u.getDeposit()>0){
			where.append("and Deposit =").append(u.getDeposit()).append(" ");
		}
		
		//参数分别是，投影（没有select就写null），要查的表实体，where语句，当前页码
		return this.cd.pageHQL(null, "Cars", where.toString(), page.getCurrentPage());
	}



	@Override
	public Page findUser(Cars car) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Page findUser(Page Page) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delCar(String string) {
		this.cd.deleteById(string);
		
	}



	@Override
	public Cars preUpdateCar(String carnumber) {
		
		return this.cd. getById(carnumber) ;
	}



	@Override
	public void updateCar(Cars car) {
		this.cd.update(car);
		
	}



	



	


	
}