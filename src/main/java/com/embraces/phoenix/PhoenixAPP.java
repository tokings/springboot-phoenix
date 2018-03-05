package com.embraces.phoenix;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = { "com.embraces.phoenix"})
@EnableAutoConfiguration
public class PhoenixAPP {
	
	private static Logger log = LoggerFactory.getLogger(PhoenixAPP.class);

	public static void main(String[] args) {
		
		// 设置Kerberos服务器连接所使用的配置文件路径（或者通过虚拟机参数-Djava.security.krb5.conf=krb5.ini指定，这种方式比较灵活，避免硬编码导致的重新编译部署问题）
		
		log.info("java home : {}", System.getProperty("java.home"));
		
		String krb5FileName = System.getProperty("java.home") + File.separator + "lib" 
				+ File.separator + "security" + File.separator + "java.security.krb5.conf";
		log.info("default java.security.krb5.conf file : {}", krb5FileName);

		String krb5 = System.getProperty("java.security.krb5.conf");
		
		if(krb5 != null && ! "".equals(krb5.trim()) ) {
			log.info("java.security.krb5.conf properties is seted: {}", krb5);
			
		} else if(new File(krb5FileName).exists()) {
			log.info("default java.security.krb5.conf file is exist: {}", krb5FileName);
			System.setProperty("java.security.krb5.conf", krb5FileName);
		} else {
			log.info("java.security.krb5.conf is not exist. set to default path ./krb5.ini");
			System.setProperty("java.security.krb5.conf", "krb5.ini");
		}
		
		log.info("current system java.security.krb5.conf path : {}", System.getProperty("java.security.krb5.conf"));
		
		SpringApplication.run(PhoenixAPP.class, args);
	}

//	@Bean
//	public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
//		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//		ObjectMapper objectMapper = PojoMapper.getObjectMapper();
//		jsonConverter.setObjectMapper(objectMapper);
//		return jsonConverter;
//	}
	
}
