package com.avril.persist;

import com.avril.domain.Renttable;
import com.avril.util.BaseDao;

public interface RenttableDao extends BaseDao<Renttable, Long> {

	void updateflag(Renttable r);

}
