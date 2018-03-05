package com.embraces.phoenix.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.embraces.phoenix.dao.TestDao;

@Service
public class TestService {

	private Logger log = LoggerFactory.getLogger(TestService.class);

	@Resource
	private TestDao testDao;
	
	public Object test() {
		
		Object ret = testDao.test();

		log.info("ret:{}", ret);
		
		return ret;
	}
}
