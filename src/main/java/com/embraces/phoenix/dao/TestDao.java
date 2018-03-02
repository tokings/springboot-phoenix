package com.embraces.phoenix.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	public Object test() {
		
		return jdbcTemplate.queryForList("select * from test.tbl_1 limit 100 offset 0");
	}
	
	
}
