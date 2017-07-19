package com.avril.util;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class BaseDaoImpl<T,PK extends Serializable> implements BaseDao<T, PK> {

	protected Class entityClass;
	@Autowired
	private HibernateTemplate template;
	
	@Override
	public T getById(PK pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T t) {
		this.template.delete(t);
		
	}

	@Override
	public void deleteById(PK pk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page pageHQL(String projection, String ClassName, String where, int pagenum) {
		//未测试过
		 final String hql =  " from "+ClassName+" "+where;
		 int num = 0; //定义整个数据库中的信息记录数
		 int allpage = 0; //定义总页数
		 Page page = new Page();
		 num = (this.template.find(hql)).size(); //先计算出整个数据记录信息
		 page.setAllRow(num); //把记录数保存到pagebean中的allrow(总记录数)里面
		 //page.setPageSize(5); //设置每页显示几条信息记录
		 allpage = Page.countTotalPage(page.getPageSize(), page.getAllRow()); //根据每页显示几条和总条数计算出，要用多少页来显示
		 page.setTotalPage(allpage);
		 page.setCurrentPage(Page.countCurrentPage(pagenum));
		 page.setOffset(Page.countOffset(page.getPageSize(),page.getCurrentPage())); //根据每页显示的信息条数和当前页数，计算当前页开始记录号
		 if(page.getTotalPage()>0)
		 {
		 //首页判断
		 //前一页判断
		 //满足条件：当当前页为第一页的时候首页和前一页不可用，否则可以使用
		 if(page.getCurrentPage() == 1){
			 page.setFirstPage(false);
			 page.setHasPreviousPage(false);
		 }else {
			 page.setFirstPage(true);
			 page.setHasPreviousPage(true);
		 }
		 //后一页判断
		 //尾页判断
		 if(page.getTotalPage() == page.getCurrentPage()){
		 page.setHasNextPage(false);
		 page.setLastPage(false);
		 }
		 else {
			 page.setHasNextPage(true);
			 page.setLastPage(true);
		 }
		 }
		 //通过回调函数把Goods根据条件查询的集合放到PageBean中的List里面
		 page.setList((List) template.execute(new HibernateCallback(){
			  public Object doInHibernate(Session session)throws HibernateException{
		 Query query = session.createQuery(hql);
		 query.setFirstResult(page.getOffset());
		 query.setMaxResults(page.getPageSize());
		 List list =query.list();
		 return list;
			  }
		 }
		 )
		 );
		 return page;
		 }
	@Override
	public Page pageCriteria(DetachedCriteria criteria, int pageIndex) {
		return null;
		
	}



}
