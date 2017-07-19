package com.avril.persist;

import com.avril.domain.Loginlogs;
import com.avril.util.BaseDao;

public interface LoginlogDao extends BaseDao<Loginlogs, Long> {

	public void addLoginlog(Loginlogs log);
}
