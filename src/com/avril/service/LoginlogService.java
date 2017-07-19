package com.avril.service;

import com.avril.domain.Loginlogs;
import com.avril.util.Page;

public interface LoginlogService {

	public void addLoginlog(Loginlogs log);

	public Page findLoginlogs(Page page);

	public void delLog(Loginlogs log);
}
