package com.embraces.phoenix.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.embraces.phoenix.dao.TestDao;

@Service
public class TestService {

	@Resource
	private TestDao testDao;
	
	public Object test() {
		
		return testDao.test();
	}
}
