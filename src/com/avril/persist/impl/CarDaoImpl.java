package com.avril.persist.impl;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * 汽车Dao
 */
import com.avril.domain.Cars;
import com.avril.domain.Roles;
import com.avril.persist.CarDao;
import com.avril.util.BaseDaoImpl;
import com.avril.util.Page;
@Repository
public class CarDaoImpl extends BaseDaoImpl<Cars, String>implements CarDao {

	public CarDaoImpl() {
		this.entityClass = Cars.class;
	}
	@Autowired
	private HibernateTemplate template;
	@Override
	public Cars getById(String pk) {
		System.out.println(pk);
    return this.template.get(Cars.class, pk);
	}
    @Override
	public Page pageHQL(String projection, String ClassName, String where, int pagenum) {
		 return super.pageHQL(projection, ClassName, where, pagenum);
	}

	@Override
	public Page pageCriteria(DetachedCriteria criteria, int pageIndex) {
		return super.pageCriteria(criteria, pageIndex);
	}
    //添加车辆信息
	@Override
	public void insert(Cars t) {
        this.template.save(t);
          }

	@Override
	public void update(Cars t) {
		System.out.println(t);
		this.template.update(t);
		}

	@Override
	public void delete(Cars t) {
		
	}
//通过携带的主键删除用户
	@Override
	public void deleteById(String pk) {
		Cars car=new Cars();
        car.setCarnumber(pk);
        this.template.delete(car);
	}

	@Override
	public List<Cars> findCar(Cars car) {
		// TODO Auto-generated method stub
		return null;
	}
	//将编辑后的汽车信息持久化到数据库
	@Override
	public void updateCar(Cars car) {
		
	}
	
	
}
