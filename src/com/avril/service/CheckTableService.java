package com.avril.service;

import com.avril.domain.Checktable;
import com.avril.util.BaseDao;
import com.avril.util.Page;

public interface CheckTableService  {

	void save(Checktable checktable);

	Page findChecktable(Page page);

	void delChecktable(Long tableid);

}
