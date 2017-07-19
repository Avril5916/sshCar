package com.avril.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avril.domain.Renttable;
import com.avril.persist.RenttableDao;
import com.avril.service.RenttableService;

@Service
public class RenttableServiceImpl implements RenttableService {

	@Autowired
	private RenttableDao rd ;

	@Override
	public Renttable findRenttableById(Long tableid) {
		
		return this.rd.getById(tableid);
	}

	
	
	
}
