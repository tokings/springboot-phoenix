package com.embraces.phoenix.controller;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phoenix")
public class TestController {

	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/test")
	public Object test() {
		
		return jdbcTemplate.queryForList("select * from test.tbl_1 limit 100 offset 0");
	}
}
