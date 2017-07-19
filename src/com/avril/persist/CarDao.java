package com.avril.persist;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.avril.domain.Cars;
import com.avril.util.BaseDao;
import com.avril.util.Page;

public interface CarDao extends BaseDao<Cars,String> {

	@Override
	public void insert(Cars t);

	public List<Cars> findCar(Cars car);

	@Override
public Cars getById(String pk);

	@Override
public void update(Cars t);

	@Override
	public void delete(Cars t);

	
	//通过ID删除
	@Override
	public void deleteById(String pk);

	@Override
	public Page pageHQL(String projection, String from, String where, int pageIndex); 
		
	

	@Override
	public Page pageCriteria(DetachedCriteria criteria, int pageIndex);

	public void updateCar(Cars car);

	


		
}	
		
