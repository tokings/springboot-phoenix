package com.embraces.phoenix.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embraces.phoenix.service.TestService;

@RestController
@RequestMapping("/phoenix")
public class TestController {

	
	@Resource
	private TestService testService;
	
	@RequestMapping("/test")
	public Object test() {
		
		return testService.test();
	}
}
